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
import com.example.graphdisplay.model.WeightModel
import com.example.graphdisplay.ui.theme.Margins

@Composable
fun WeightGraphView() {
    val weightModel = WeightModel()

    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        Text(text = "Users Weight", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        WeightGraphRow(weightModel)
    }
}

@Composable
fun WeightGraphRow(weightModel: WeightModel) {
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