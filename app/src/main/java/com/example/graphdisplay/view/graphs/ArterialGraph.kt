package com.example.graphdisplay.view.graphs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphdisplay.line.LineChart
import com.example.graphdisplay.model.ArterialModel
import com.example.graphdisplay.ui.theme.Margins
import com.example.graphdisplay.viewModel.ArterialViewModel

@Composable
fun ArterialGraphView(name : String?) {
    Text(text = name.toString())
//    val arterialModel = ArterialViewModel()
//
//    Column(
//        modifier = Modifier.padding(
//            horizontal = Margins.horizontal,
//            vertical = Margins.vertical
//        )
//    ) {
//        Text(text = "Arterial Pressure", textAlign = TextAlign.Center,
//        modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
//        ArterialGraphRow(arterialModel)
//    }
}

@Composable
fun ArterialGraphRow(arterialModel: ArterialViewModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = arterialModel.arterialData,
            horizontalOffset = arterialModel.horizontalOffset,
            pointDrawer = arterialModel.pointDrawer
        )
    }
}

//@Preview
//@Composable
//fun ArterialGraphPreview() = ArterialGraphView()