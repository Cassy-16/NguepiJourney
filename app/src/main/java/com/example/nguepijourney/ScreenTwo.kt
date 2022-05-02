package com.example.nguepijourney

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nguepijourney.ui.theme.NguepiJourneyTheme

class ScreenTwo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NguepiJourneyTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .width(70.dp)
                        .height(3.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Box(
                        modifier = Modifier
                            .background(color = Color.Gray)
                            .fillMaxSize()
                            .size(width = 600.dp, height = 90.dp)
                            .padding(90.dp)
                    ) {

                        Text(
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(10.dp)
                                .align(Alignment.TopCenter),

                            text = "FULL NAME: " +
                                    "\n" +
                                    "Hilary Cassidy Nguepi Nangmo" +
                                    "\n" +
                                    "\n" +
                                    "COURSE:" +
                                    "\n" +
                                    "Dip: ICT in Application Development" +
                                    "\n" +
                                    "\n" +
                                    "DEPARTMENT:" +
                                    "\n" +
                                    "Information Technology" +
                                    "\n" +
                                    "\n" +
                                    "STUDENT NUMBER: 220346887", color = Color.Black
                        )

                    }

                }
                Button(
                    onClick = {},
                    modifier = Modifier.paddingFromBaseline(top = 600.dp)
                        .size(width = 400.dp, height = 60.dp),
                    border = BorderStroke(3.dp, brush = SolidColor(Color.DarkGray)),
                    shape = CutCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))
                )
                {
                    Text(text = "CURRENT MODULES", fontSize = 18.sp, color = Color.Black)
                }
                Button(onClick = {
                    val navigate = Intent(this@ScreenTwo, MainActivity::class.java)
                    startActivity(navigate)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Return",
                        modifier = Modifier.size(width = 60.dp, height = 30.dp)
                            .background(color = Color.White),

                        Color.Black,
                    )


                    Text(text = "BACK",
                       modifier= Modifier
                        .size(width = 60.dp,height = 30.dp)
                        .background(color = Color.White),
                        color= Color.Black, textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h6)

                }
            }
        }
    }
}

