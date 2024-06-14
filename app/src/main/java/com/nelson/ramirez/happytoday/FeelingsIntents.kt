package com.nelson.ramirez.happytoday

import android.content.Context
import java.lang.ref.WeakReference

sealed class FeelingsIntents {
    data class Save(val context: WeakReference<Context>) : FeelingsIntents()
    data class UpdateFeeling(val key: String, val value: Boolean) : FeelingsIntents()
    data object Other : FeelingsIntents()
}