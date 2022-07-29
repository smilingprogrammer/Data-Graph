package com.example.graphdisplay.view.graphs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.graphdisplay.line.LineChart
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.line.LineChartData.Point
import com.example.graphdisplay.viewModel.ArterialViewModel

@Composable
fun ArterialGraphView(points: List<Point>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Arterial Pressure", textAlign = TextAlign.Center,
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        ArterialGraphRow(points)
    }
}

@Composable
fun ArterialGraphRow(points: List<Point>) {
    val arterialModel = ArterialViewModel()
    val arterialData by remember {
        mutableStateOf(LineChartData(points = points))
    }
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = arterialData,
            horizontalOffset = arterialModel.horizontalOffset,
            pointDrawer = arterialModel.pointDrawer
        )
    }
}

private fun randomYValue(): Float = (100f * Math.random()).toFloat() + 45f