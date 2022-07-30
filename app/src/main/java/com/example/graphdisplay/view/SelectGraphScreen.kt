package com.example.graphdisplay.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select from the options below")
        Spacer(modifier = Modifier.padding(4.dp))
        GraphRow(text = "Arterial Pressure Graph", navigateTo = ScreenList.ArterialForm)
        GraphRow(text = "Daily Activity Graph", navigateTo = ScreenList.DailyForm)
        GraphRow(text = "Subcutaneous Fat Graph", navigateTo = ScreenList.FatForm)
        GraphRow(text = "User's Steps Graph", navigateTo = ScreenList.StepsForm)
        GraphRow(text = "User's Waist Graph", navigateTo = ScreenList.WaistForm)
        GraphRow(text = "User's Weight Graph", navigateTo = ScreenList.WeightForm)
    }
}

@Composable
fun GraphRow(
    text: String,
    navigateTo: ScreenList
) {
    Row(modifier = Modifier.padding(horizontal = Margins.horizontal, vertical = Margins.vertical)) {
        TextButton(
            border = BorderStroke(width = 1.dp, color = Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            ),
            onClick = { ScreenListStatus.navigateTo(navigateTo) }
        ) {
            Text(text = text)
        }
    }
}