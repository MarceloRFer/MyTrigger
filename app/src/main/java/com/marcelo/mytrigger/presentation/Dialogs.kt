package com.marcelo.mytrigger.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.dialog.Confirmation
import androidx.wear.compose.material.dialog.Dialog

@Preview
@Composable
fun Dialogs(
    modifier: Modifier = Modifier
) {
    var confirmationShowDialog by remember { mutableStateOf(false) }
    var confirmationStatus by remember { mutableStateOf("") }
    var alertShowDialog by remember { mutableStateOf(false) }
    var alertStatus by remember { mutableStateOf("") }
    val dialogDismissed = "Desconsiderar"
    val dialogTimedOut = "Time Out"
    val dialogNo = "Não"
    val dialogYes = "Sim"

    ScalingLazyColumn(
        modifier = modifier,
        anchorType = ScalingLazyListAnchorType.ItemStart
    ) {
        item {
            Chip(
                onClick = {
                    confirmationStatus = ""
                    confirmationShowDialog = true
                },
                colors = ChipDefaults.primaryChipColors(),
                label = { Text( "Confirmation") },
                secondaryLabel = { Text(confirmationStatus) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Chip(
                onClick = {
                    alertStatus = ""
                    alertShowDialog = true
                },
                colors = ChipDefaults.primaryChipColors(),
                label = { Text("Shoot") },
                secondaryLabel = { Text(alertStatus) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    Dialog(
        showDialog = confirmationShowDialog,
        onDismissRequest = {
            if (confirmationStatus.isEmpty()) confirmationStatus = dialogDismissed
            confirmationShowDialog = false
        }
    ) {
        Confirmation(
            onTimeout = {
                confirmationStatus = dialogTimedOut
                confirmationShowDialog = false
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check",
                    modifier = Modifier.size(48.dp)
                )
            }
        ) {
            Text(
                text = "Confirma",
                textAlign = TextAlign.Center
            )
        }
    }

    val scrollState = rememberScalingLazyListState()
    Dialog(
        showDialog = alertShowDialog,
        onDismissRequest = {
            if (alertStatus.isEmpty()) alertStatus = dialogDismissed
            alertShowDialog = false
        },
        scrollState = scrollState
    ) {
        Alert(
            title = {
                Text(
                    text = "Iniciar",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
            },
            negativeButton = {
                Button(
                    onClick = {
                        alertStatus = dialogNo
                        alertShowDialog = false
                    },
                    colors = ButtonDefaults.secondaryButtonColors()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = dialogNo
                    )
                }
            },
            positiveButton = {
                Button(
                    onClick = {
                        alertStatus = dialogYes
                        alertShowDialog = false
                    },
                    colors = ButtonDefaults.primaryButtonColors()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = dialogYes
                    )
                }
            },
            scrollState = scrollState
        ) {
            Text(
                text = "confirme",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
