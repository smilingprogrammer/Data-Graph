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
import com.example.graphdisplay.viewModel.WeightViewModel

@Composable
fun WeightGraphView() {
    val weightModel = WeightViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Users Weight", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        WeightGraphRow(weightModel)
    }
}

@Composable
fun WeightGraphRow(weightModel: WeightViewModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = weightModel.weightData,
            horizontalOffset = weightModel.horizontalOffset,
            pointDrawer = weightModel.pointDrawer
        )
    }
}

@Preview
@Composable
fun WeightGraphPreview() = WeightGraphView()