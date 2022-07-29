package com.example.graphdisplay.view.graphs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphdisplay.line.LineChart
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.viewModel.WeightViewModel

@Composable
fun WeightGraphView(points: List<LineChartData.Point>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Users Weight", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        WeightGraphRow(points)
    }
}

@Composable
fun WeightGraphRow(points: List<LineChartData.Point>) {
    val weightModel = WeightViewModel()
    val weightData by remember {
        mutableStateOf(LineChartData(points = points))
    }
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = weightData,
            horizontalOffset = weightModel.horizontalOffset,
            pointDrawer = weightModel.pointDrawer
        )
    }
}