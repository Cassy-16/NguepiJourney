package com.example.nguepijourney

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nguepijourney.ui.theme.NguepiJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NguepiJourneyTheme {
                var visible: MutableState<Boolean> = remember { mutableStateOf(false) }
                Alert(setVisible= visible)
                TextView()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .width(40.dp)
                        .height(10.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(painter = painterResource(id = R.drawable.cov), contentDescription = null,
                    modifier = Modifier
                        .width(400.dp)
                        .height(600.dp))
                   Box(
                        modifier = Modifier
                            .size(width = 750.dp, height = 80.dp)
                            .padding(all = Dp(10F))
                            .background(color = Color.White)
                            .clip(CutCornerShape(15.dp))

                            .border(
                                border = BorderStroke(
                                    width = 3.dp,
                                    brush = SolidColor(Color.DarkGray)
                                )
                            )



                    )
                    {
                        Icon(

                        imageVector = Icons.Rounded.Info,
                        contentDescription = "Info description",
                        Modifier.padding(end=40.dp, start=5.dp)
                            .size(width = 40.dp, height = 50.dp),
                        Color.Black


                    )
                        TextButton(onClick = { visible.value = true }) {
                            Text(text ="INFO",
                                modifier= Modifier
                                    .size(width = 300.dp,height = 200.dp),
                                color= Color.Black, textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h6
                            )
                        }
                    }

                }
                Button(onClick = {
                    val navigate = Intent(this@MainActivity,ScreenTwo::class.java)
                    startActivity(navigate)
                },
                        modifier = Modifier.paddingFromBaseline(top = 600.dp)
                            .size(width = 400.dp, height = 60.dp),
                       border = BorderStroke(3.dp, brush = SolidColor(Color.DarkGray)),
                       shape = CutCornerShape(20.dp),
                       colors = ButtonDefaults.
                       buttonColors(backgroundColor = colorResource(id = R.color.white))



                ) {
                    Text(text = "START JOURNEY", fontSize = 18.sp, color= Color.Black)

                }


            }
        }
    }
}
@Composable
fun TextView() {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 30.dp),


        verticalArrangement = Arrangement.Top,

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(

            text = "Welcome to My Jetpack Compose Journey",
            color=MaterialTheme.colors.onSecondary,
            style= MaterialTheme.typography.h6,
            textAlign = TextAlign.Center


        )
    }
}
@Composable
fun Alert(setVisible: MutableState<Boolean>)
{
    if(setVisible.value){
        AlertDialog(
            onDismissRequest = { setVisible.value=false },

            confirmButton = {
                TextButton(onClick = {setVisible.value=false}) {
                    Text(text = "OK")
                }
            },
            title = { Text(text = "My dive thus far",color = Color.Black,style= MaterialTheme.typography.h6)},

            text = { Text(text = "To be honest, When we were told by Dr Tom last year that we were going to be " +
                    "thought Mobile Programming in the programming language Kotlin and not Java, I was terrified as I had gotten so comfortable with Java. " +
                    "\n" +
                    "Now that our first assignment this year was based on documenting Jetpack compose as a new solution in Android, I got the chance to learn the background of Jetpack compose " +

                    "which helped rid my fear." +
                    "\n" +
                    " Coding thus far I can definitely see that the Jetpack compose library has and is helping me gain better performance and data flow in my application." +
                    "\n" +
                    "I can not wait to dive deeper in Kotlin.",color = Color.Black,style = MaterialTheme.typography.subtitle2)}
        )


    }
}
