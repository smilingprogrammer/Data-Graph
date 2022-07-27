package com.example.graphdisplay.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class ScreenList {
    object SelectForm : ScreenList()
    object ArterialForm : ScreenList()
    object DailyForm : ScreenList()
    object FatForm : ScreenList()
    object StepsForm : ScreenList()
    object WaistForm : ScreenList()
    object WeightForm : ScreenList()
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