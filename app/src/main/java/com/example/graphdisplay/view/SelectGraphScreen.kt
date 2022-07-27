package com.example.graphdisplay.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphdisplay.ui.theme.Margins

@Composable
fun SelectGraphScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Select Graph") }) }
    ) { SelectGraphScreenContent() }
}

@Composable
private fun SelectGraphScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GraphRow(text = "Arterial Pressure Graph", navigateTo = ScreenList.ArterialForm)
        GraphRow(text = "Daily Activity Graph", navigateTo = ScreenList.DailyForm)
        GraphRow(text = "Subcutaneous Fat Graph", navigateTo = ScreenList.FatForm)
        GraphRow(text = "User's Steps Graph", navigateTo = ScreenList.StepsForm)
        GraphRow(text = "User's Waist Graph", navigateTo = ScreenList.WaistForm)
        GraphRow(text = "User's Weight Graph", navigateTo = ScreenList.WeightForm)
    }
}

@Composable
private fun GraphRow(
    text: String,
    navigateTo: ScreenList
) {
    Row(modifier = Modifier.padding(horizontal = Margins.horizontal, vertical = Margins.vertical)) {
        TextButton(
            onClick = { ScreenListStatus.navigateTo(navigateTo) }
        ) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun SelectGraphScreenPreview() = SelectGraphScreen()