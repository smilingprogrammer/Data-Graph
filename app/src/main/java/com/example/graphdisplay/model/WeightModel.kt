package com.example.graphdisplay.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.line.LineChartData.Point
import com.example.graphdisplay.line.renderer.point.FilledCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.HollowCircularPointDrawer
import com.example.graphdisplay.line.renderer.point.NoPointDrawer
import com.example.graphdisplay.line.renderer.point.PointDrawer

class WeightModel {
    var weightData by mutableStateOf(
        LineChartData(
            points = listOf(
                Point(randomYValue(), "Sun"),
                Point(randomYValue(), "Mon"),
                Point(randomYValue(), "Tues"),
                Point(randomYValue(), "Wed"),
                Point(randomYValue(), "Thur"),
                Point(randomYValue(), "Fri"),
                Point(randomYValue(), "Sat")
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