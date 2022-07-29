package com.example.graphdisplay.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.line.renderer.point.FilledCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.HollowCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.NoPointDrawer
import com.example.graphdisplay.line.renderer.point.PointDrawer

class ArterialViewModel: ViewModel() {

    var text = mutableStateOf("")
    var text1 = mutableStateOf("")
    var text2 = mutableStateOf("")
    var text3 = mutableStateOf("")
    var text4 = mutableStateOf("")
    var text5 = mutableStateOf("")
    var text6 = mutableStateOf("")
    var horizontalOffset by mutableStateOf(5f)
    var pointDrawerType by mutableStateOf(PointDrawerType.Filled)
    val pointDrawer: PointDrawer
        get() {
            return when (pointDrawerType) {
                PointDrawerType.None -> NoPointDrawer
                PointDrawerType.Filled -> FilledCircularPointDrawer()
                PointDrawerType.Hollow -> HollowCircularPointDrawer()
            }
        }
}