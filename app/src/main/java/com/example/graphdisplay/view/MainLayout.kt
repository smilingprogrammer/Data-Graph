package com.example.graphdisplay.view

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.graphdisplay.ui.theme.GraphDisplayTheme
import com.example.graphdisplay.view.formview.*

@Composable
fun MainApp() {
    GraphDisplayTheme {
        AppContent()
    }
}

@Composable
fun AppContent() {
    Crossfade(ScreenListStatus.currentChart) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                ScreenList.SelectForm -> SelectGraphScreen()
                ScreenList.ArterialForm -> ArterialForm(rememberNavController())
                ScreenList.DailyForm -> DailyForm()
                ScreenList.FatForm -> FatForm()
                ScreenList.StepsForm -> StepsForm()
                ScreenList.WaistForm -> WaistForm()
                ScreenList.WeightForm -> WeightForm()
            }
        }
    }
}