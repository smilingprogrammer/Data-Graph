package com.example.graphdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.graphdisplay.view.graphs.*
import com.example.graphdisplay.ui.theme.GraphDisplayTheme
import com.example.graphdisplay.view.MainApp
import com.example.graphdisplay.view.Navigation
import com.example.graphdisplay.view.formview.ArterialForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {
            MainApp()
        }
//        setContent {
//            GraphDisplayTheme {
//                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//                    GraphScreenContent()
//                    WeightGraphView()
//                    WaistGraphView()
//                    DailyGraphView()
//                    StepsGraphView()
//                    FatGraphView()
//                    ArterialGraphView()
//                }
//            }
//        }
    }
}