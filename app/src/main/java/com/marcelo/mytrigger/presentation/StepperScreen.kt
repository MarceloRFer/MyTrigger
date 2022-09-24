package com.marcelo.mytrigger.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

@Composable
fun StepperScreen (
    displayValue: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
)  {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Stepper(
            value = displayValue,
            onValueChange = onValueChange,
            valueProgression = 0..10,
            increaseIcon = { Icon(StepperDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(StepperDefaults.Decrease, "Decrease") }
        ) {
            Dormir()
            Text("Enter: $displayValue Sec")
        }

    }
}

fun Dormir(){
    Thread.sleep(1000L)
    Log.d("MARCELO","Entrei na THREAD")
}