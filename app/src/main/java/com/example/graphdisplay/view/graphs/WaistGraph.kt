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
import com.example.graphdisplay.viewModel.WaistViewModel

@Composable
fun WaistGraphView() {
    val waistModel = WaistViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Users Waist", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        WaistGraphRow(waistModel)
    }
}

@Composable
fun WaistGraphRow(waistModel: WaistViewModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = waistModel.waistData,
            horizontalOffset = waistModel.horizontalOffset,
            pointDrawer = waistModel.pointDrawer
        )
    }
}

@Preview
@Composable
fun WaistGraphPreview() = WaistGraphView()