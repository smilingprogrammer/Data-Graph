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
import com.example.graphdisplay.model.WaistModel
import com.example.graphdisplay.ui.theme.Margins

@Composable
fun WaistGraphView() {
    val waistModel = WaistModel()

    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        Text(text = "Users Waist", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        WaistGraphRow(waistModel)
    }
}

@Composable
fun WaistGraphRow(waistModel: WaistModel) {
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