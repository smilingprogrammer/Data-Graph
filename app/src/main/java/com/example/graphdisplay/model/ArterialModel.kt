package com.example.graphdisplay.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.line.renderer.point.FilledCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.HollowCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.NoPointDrawer
import com.example.graphdisplay.line.renderer.point.PointDrawer

class ArterialModel {
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