package com.nelson.ramirez.happytoday.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.nelson.ramirez.happytoday.ui.components.FeelingsDialog
import com.nelson.ramirez.happytoday.FeelingsIntents
import java.lang.ref.WeakReference

@Composable
fun HomeScreen(
    state: MutableState<Map<String, Boolean>>,
    showDialog: MutableState<Boolean>,
    intentHandler: (FeelingsIntents) -> Unit
) {
    FeelingsDialog(intentHandler, shouldShowDialog = remember {
        showDialog
    })
    Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(style = MaterialTheme.typography.titleLarge, text = "What made you happy today?")
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(3)
        ) {
            state.value.forEach {
                item {
                    Button(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .padding(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (it.value) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.primary
                        ),
                        onClick = {
                            intentHandler(
                                FeelingsIntents.UpdateFeeling(
                                    key = it.key,
                                    value = !it.value
                                )
                            )
                        },
                    ) {
                        Text(it.key, maxLines = 1)
                    }

                }
            }
            item {
                Button(
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .padding(4.dp),
                    onClick = { intentHandler(FeelingsIntents.Other) }) {
                    Text("Other...")
                }
            }
        }
        val context = LocalContext.current
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { intentHandler(FeelingsIntents.Save(WeakReference(context))) }) {
            Text(text = "Save")
        }
    }
}