package com.nelson.ramirez.happytoday

import android.content.Context

class FeelingsDataSource() {
    // default values
    val _defaultFeelings = mapOf("Family" to false, "Friends" to false, "Work" to false)
    val feelings = _defaultFeelings.toMutableMap()

    fun saveFeelings(context: Context) {
        val prefs = context.getSharedPreferences("feelings", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        feelings.forEach { (t, u) ->
            editor.putBoolean(t, u)
        }
        editor.apply()
    }

    fun loadFeelings(context: Context) {
        val prefs = context.getSharedPreferences("feelings", Context.MODE_PRIVATE)
        feelings.clear()
        val allPrefs = prefs.all as Map<String, Boolean>
        if (allPrefs.isEmpty()) {
            feelings.putAll(_defaultFeelings)
            return
        }
        feelings.putAll(allPrefs)
        println("loaded feelings: $feelings")
    }
}