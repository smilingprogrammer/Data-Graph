package com.example.graphdisplay

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.graphdisplay.line.LineChart
import com.example.graphdisplay.model.ExampleModel
import com.example.graphdisplay.ui.theme.Margins.horizontal
import com.example.graphdisplay.ui.theme.Margins.vertical
import com.example.graphdisplay.ui.theme.Margins.verticalLarge

@Composable
fun GraphScreenContent() {
    val lineChartDataModel = ExampleModel()

    Column(
        modifier = Modifier.padding(
            horizontal = horizontal,
            vertical = vertical
        )
    ) {
        GraphRow(lineChartDataModel)
//        HorizontalOffsetSelector(lineChartDataModel)
//        OffsetProgress(lineChartDataModel)
    }
}

//@Composable
//fun HorizontalOffsetSelector(lineChartDataModel: ExampleModel) {
//    val selectedType = lineChartDataModel.pointDrawerType
//
//    Row(
//        modifier = Modifier.padding(
//            horizontal = horizontal,
//            vertical = verticalLarge
//        ),
//        verticalAlignment = CenterVertically
//    ) {
//        Text("Point Drawer")
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = horizontal, vertical = vertical)
//                .align(CenterVertically)
//        ) {
//            ExampleModel.PointDrawerType.values().forEach { type ->
//                OutlinedButton(
//                    border = ButtonDefaults.outlinedBorder.takeIf { selectedType == type },
//                    onClick = { lineChartDataModel.pointDrawerType = type }
//                ) {
//                    Text(type.name)
//                }
//            }
//        }
//    }
//}

//@Composable
//fun OffsetProgress(lineChartDataModel: ExampleModel) {
//    Row(
//        modifier = Modifier.padding(horizontal = horizontal),
//        verticalAlignment = CenterVertically
//    ) {
//        Text("Offset")
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(CenterVertically)
//        ) {
//            Slider(
//                value = lineChartDataModel.horizontalOffset,
//                onValueChange = { lineChartDataModel.horizontalOffset = it },
//                valueRange = 0f.rangeTo(25f)
//            )
//        }
//    }
//}

@Composable
fun GraphRow(lineChartDataModel: ExampleModel) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        LineChart(
            lineChartData = lineChartDataModel.lineChartData,
            horizontalOffset = lineChartDataModel.horizontalOffset,
            pointDrawer = lineChartDataModel.pointDrawer
        )
    }
}

@Preview
@Composable
fun GraphScreenPreview() = GraphScreenContent()