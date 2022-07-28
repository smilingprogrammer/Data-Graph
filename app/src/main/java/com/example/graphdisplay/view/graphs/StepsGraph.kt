package com.example.graphdisplay.view.graphs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphdisplay.line.LineChart
import com.example.graphdisplay.ui.theme.Margins
import com.example.graphdisplay.viewModel.StepsViewModel

@Composable
fun StepsGraphView() {
    val stepsModel = StepsViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Users Steps", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        StepsGraphRow(stepsModel)
    }
}

@Composable
fun StepsGraphRow(stepsModel: StepsViewModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = stepsModel.stepsData,
            horizontalOffset = stepsModel.horizontalOffset,
            pointDrawer = stepsModel.pointDrawer
        )
    }
}