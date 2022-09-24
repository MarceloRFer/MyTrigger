package com.marcelo.mytrigger.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.marcelo.mytrigger.presentation.theme.MyTriggerTheme
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTriggerTheme {
                val navController = rememberSwipeDismissableNavController()
                var displayValueForUserInput by remember { mutableStateOf(0) }

                SwipeDismissableNavHost(
                    navController = navController,
                    startDestination = "list"
                ) {
                    composable("list") {
                        ScalingLazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 32.dp),
                            verticalArrangement = Arrangement.Center,
                        ) {

                            item {
                                ListHeader {
                                    Text("Trigger v0.1")
                                }
                            }

                            item {
                                Chip(
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                        .fillMaxSize(),
                                    onClick = { navController.navigate("interval") },
                                    label = {
                                        Text(
                                            text = "Interval",
                                            color = Color.White,
                                            textAlign = TextAlign.Center )
                                    },
                                    secondaryLabel = {
                                        Text(text = "$displayValueForUserInput Seconds",
                                        textAlign = TextAlign.Center )
                                    }
                                )
                            }

                            item {
                                Chip(
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                        .fillMaxSize(),
                                    onClick = { navController.navigate("grip") },
                                    label = {
                                        Text(
                                            text = "Grip Monitor",
                                            textAlign = TextAlign.Center,
                                            color = Color.White
                                        )
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                        .fillMaxSize(),
                                    onClick = { navController.navigate("about") },
                                    label = {
                                        Text(
                                            text = "About",
                                            textAlign = TextAlign.Center,
                                            color = Color.White
                                        )
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                        .fillMaxSize(),
                                    onClick = { navController.navigate("dialogo") },
                                    label = {
                                        Text(
                                            text = "Dialog",
                                            textAlign = TextAlign.Center,
                                            color = Color.White
                                        )
                                    }
                                )
                            }
                        }
                    }
                    composable(route = "interval") {
                        StepperScreen(
                            displayValue = displayValueForUserInput,
                            onValueChange = {displayValueForUserInput = it}
                        )
                    }
                    composable(route = "grip") {
                        MenuGrip()
                    }
                    composable(route = "about") {
                        MenuAbout()
                    }
                    composable(route = "dialogo") {

                    }
                }
            }
        }
    }
}

//@Composable
//fun MenuInterval(
//){
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Intervalo Screen")
//    }
//}

@Preview
@Composable
fun MenuGrip(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Grip Screen")
        Button(onClick = {  }) {
            Text(text = "Voltar")
        }
    }
}

@Preview
@Composable
fun MenuAbout()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("MyTrigger v0.1\nAug 2022\nMRF Wear")
    }
}


