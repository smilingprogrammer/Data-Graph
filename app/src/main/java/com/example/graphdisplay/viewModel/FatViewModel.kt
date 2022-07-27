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
import com.example.graphdisplay.model.PointDrawerType
import kotlin.math.absoluteValue

class FatViewModel: ViewModel() {

    var text by mutableStateOf("")
    var text1 by mutableStateOf("")
    var text2 by mutableStateOf("")
    var text3 by mutableStateOf("")
    var text4 by mutableStateOf("")
    var text5 by mutableStateOf("")
    var text6 by mutableStateOf("")

    var arterialData by mutableStateOf(
        LineChartData(
            points = listOf(
                LineChartData.Point(randomYValue(), "Sun"),
                LineChartData.Point(randomYValue(), "Mon"),
                LineChartData.Point(randomYValue(), "Tue"),
                LineChartData.Point(randomYValue(), "Wed"),
                LineChartData.Point(randomYValue(), "Thur"),
                LineChartData.Point(randomYValue(), "Fri"),
                LineChartData.Point(randomYValue(), "Sat")
            )
        )
    )
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

    private fun randomYValue(): Float = (100f * Math.random()).toFloat() + 45f
}