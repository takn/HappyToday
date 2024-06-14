package com.nelson.ramirez.happytoday

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FeelingsViewModel(private val repository: FeelingsRepository) :
    ViewModel() {
    fun processIntent(intent: FeelingsIntents) {
        showDialog.value = false
        when (intent) {
            is FeelingsIntents.Save -> {
                // save data
                intent.context.get()?.let {
                    repository.saveFeelings(it)
                }
            }

            is FeelingsIntents.UpdateFeeling -> {
                repository.updateFeeling(intent.key, intent.value)
                feelingsData.value = repository.feelings
            }

            is FeelingsIntents.Other -> {
                showDialog.value = true
            }
        }
    }

    fun loadFeelings(context: Context) {
        repository.loadFeelings(context)
        feelingsData.value = repository.feelings
    }

    val showDialog = mutableStateOf(false)
    val feelingsData = mutableStateOf(repository.feelings)

    companion object {
        fun provideFactory(
            repository: FeelingsRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return FeelingsViewModel(repository) as T
            }
        }
    }
}