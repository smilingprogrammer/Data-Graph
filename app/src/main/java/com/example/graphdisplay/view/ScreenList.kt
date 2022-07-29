package com.example.graphdisplay.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class ScreenList(val route: String) {
    object SelectForm : ScreenList("Home")
    object ArterialForm : ScreenList("ArterialForm")
    object DailyForm : ScreenList("DailyForm")
    object FatForm : ScreenList("FatForm")
    object StepsForm : ScreenList("StepsForm")
    object WaistForm : ScreenList("WaistForm")
    object WeightForm : ScreenList("WeightForm")
    object ArterialGraph : ScreenList("ArterialGraph/{points}")
    object DailyGraph : ScreenList("DailyGraph/{points}")
    object FatGraph : ScreenList("FatGraph/{points}")
    object StepsGraph : ScreenList("StepsGraph/{points}")
    object WaistGraph : ScreenList("WaistGraph/{points}")
    object WeightGraph : ScreenList("WeightGraph/{points}")
}

object ScreenListStatus {
    var currentChart by mutableStateOf<ScreenList>(ScreenList.SelectForm)
        private set

    fun navigateTo(screen: ScreenList) {
        currentChart = screen
    }

    fun navigateHome() {
        navigateTo(ScreenList.SelectForm)
    }
}