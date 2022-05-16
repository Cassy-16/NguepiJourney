package com.example.nguepijourney

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import com.example.nguepijourney.ui.theme.NguepiJourneyTheme
import kotlin.system.exitProcess

class ScreenThree : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NguepiJourneyTheme {

                var h1= Mod("Application Development Theory 3","Theory","Year-round")
                var h2= Mod("Information System 3","Theory","Year-round")
                var h3= Mod("Project Management 3","Theory","Year-round")
                var h4= Mod("Professional Practice","Theory","Year-round")

                var h5= Mod("Application Development Practice 3","Practical","Year-round")
                var h6= Mod("Project 3","Practical","Year-round")
                var h7= Mod("Project Presentation 3","Practical","Year-round")
                var h8= Mod("Mobile Programming 2","Practical","Semester")
                val modules=listOf (h1,h2,h3,h4,h5,h6,h7,h8)
                Convesation(modules)
            }
        }
    }
}

data class Mod(val moduleName:String, var moduleType: String, var moduleDuration: String)

@Composable
fun Greeting(module: Mod )
{

    Row() {

        Image(painter = painterResource(id=R.drawable.book),
            contentDescription ="book",
           modifier = Modifier
                .size(80.dp)

        )

        Spacer(modifier = Modifier.width(23.2.dp))

        Column(modifier = Modifier.clickable {    })

        {
            Text(text = "${module.moduleName}",
                color = Color.Black,
                style= MaterialTheme.typography.body1

            )
            Spacer(modifier = Modifier.width(14.2.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                color = Color.White, elevation = 800.dp) {
                Text(text = "${module.moduleType}",style= MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(all = 1.6.dp),
                   maxLines = 1)
            }

            Spacer(modifier = Modifier.width(14.2.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                color = Color.White, elevation = 800.dp) {
                Text(text = "${module.moduleDuration}",style= MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(all = 1.6.dp),
                    maxLines =  1)
            }


        }
    }
}
@Composable
fun Convesation (messages: List<Mod>)
{

    var visible: MutableState<Boolean> = remember { mutableStateOf(false) }
    Aler(setVisible= visible)
       Column() {

    LazyColumn()
    {
        items(messages) { s -> Greeting(module = s) }
    }
        Button(
            onClick = {
                //val navigate = Intent(this@ScreenThree, ScreenTwo::class.java)
              //  startActivity(navigate)
            },
            modifier = Modifier.paddingFromBaseline(top = 0.dp)
                .size(width = 400.dp, height = 40.dp),
            border = BorderStroke(3.dp, brush = SolidColor(Color.DarkGray)),
            shape = CutCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))
        )
        {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Return",
                modifier = Modifier.size(width = 40.dp, height = 60.dp)
                    .background(color = Color.White),

                Color.Black,
            )

            Text(text = "BACK", fontSize = 15.sp, color = Color.Black)
        }

        Button(
            onClick = {
               visible.value = true
            },
            modifier = Modifier.paddingFromBaseline(top = 0.dp)
                .size(width = 400.dp, height = 40.dp),
            border = BorderStroke(3.dp, brush = SolidColor(Color.DarkGray)),
            shape = CutCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))
        ) {
            Icon(
                imageVector = Icons.Outlined.ExitToApp,
                contentDescription = "Exit",
                modifier = Modifier.size(width = 40.dp, height = 40.dp)
                    .background(color = Color.White),

                Color.Black,
            )

            Text(text = "GOODBYE", fontSize = 15.sp, color = Color.Red)

    }
}

@Composable
fun DefaultPreview(){
    NguepiJourneyTheme {
        var h1= Mod("Application Development Theory 3","Theory","Year-round")
        var h2= Mod("Information System 3","Theory","Year-round")
        var h3= Mod("Project Management 3","Theory","Year-round")
        var h4= Mod("Professional Practice","Theory","Year-round")

        var h5= Mod("Application Development Practice 3","Practical","Year-round")
        var h6= Mod("Project 3","Practical","Year-round")
        var h7= Mod("Project Presentation 3","Practical","Year-round")
        var h8= Mod("Mobile Programming 2","Practical","Semester")
        val modules=listOf (h1,h2,h3,h4,h5,h6,h7,h8)
        Convesation(modules)
    }

}}
@Composable
fun Aler(setVisible: MutableState<Boolean>)
{
    //val screens=(LocalContext.current as? Activity)
    if(setVisible.value){
        AlertDialog(
            onDismissRequest = { setVisible.value=false },
            dismissButton ={
                TextButton(onClick = {setVisible.value=false}) {
                    Text(text = "NO",color = Color.Black,style = MaterialTheme.typography.body1)
                }
            },

            confirmButton = {
                TextButton(onClick = { exitProcess(0)}) {
                    Text(text = "YES",color = Color.Red,style = MaterialTheme.typography.body1)
                }
            },

            text = { Text(text = "Leaving now?",color = Color.Black,style = MaterialTheme.typography.h6)}
        )


    }
}