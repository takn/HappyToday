package com.nelson.ramirez.happytoday.data

import android.content.Context

class FeelingsRepository(private val dataSource: FeelingsDataSource) {
    fun updateFeeling(key: String, selected: Boolean) {
        dataSource.feelings[key] = selected
    }

    // better to do it with room, but out of time to do the Room implementation
    fun saveFeelings(context: Context) {
        dataSource.saveFeelings(context)
    }

    fun loadFeelings(context: Context) {
        dataSource.loadFeelings(context)
    }

    val feelings
        get() = dataSource.feelings.toMap()

}