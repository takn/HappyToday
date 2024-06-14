package com.nelson.ramirez.happytoday.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.nelson.ramirez.happytoday.FeelingsIntents

@Composable
fun FeelingsDialog(intentHandler: (FeelingsIntents) -> Unit, shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) {
        var input by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = { Text(text = "Add \"Other\" Option") },

            confirmButton = {
                Button(
                    onClick = {
                        if (input.isNotEmpty()) {
                            intentHandler(FeelingsIntents.UpdateFeeling(input, true))
                        }
                        shouldShowDialog.value = false
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            },
            text = {
                TextField(value = input, onValueChange = {
                    if (it.length < 15) input = it
                }, singleLine = true)
            }
        )
    }
}