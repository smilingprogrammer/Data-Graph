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
import com.example.graphdisplay.model.FatModel
import com.example.graphdisplay.ui.theme.Margins

@Composable
fun FatGraphView() {
    val fatModel = FatModel()

    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        Text(text = "Subcutaneous Fat", textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        FatGraphRow(fatModel)
    }
}

@Composable
fun FatGraphRow(fatModel: FatModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = fatModel.fatModel,
            horizontalOffset = fatModel.horizontalOffset,
            pointDrawer = fatModel.pointDrawer
        )
    }
}

@Preview
@Composable
fun FatGraphPreview() = FatGraphView()