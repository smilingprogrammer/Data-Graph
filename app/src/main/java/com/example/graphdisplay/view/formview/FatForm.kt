package com.example.graphdisplay.view.formview

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.graphdisplay.line.LineChartData
import com.example.graphdisplay.view.ScreenListStatus
import com.example.graphdisplay.viewModel.FatViewModel
import com.google.gson.Gson

@Composable
fun FatForm(navController: NavController) {
    val fatViewModel = FatViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "Subcutaneous Fat Form") }
            )
        },
    ) { FatScreenForm(navController, fatViewModel) }
}

@Composable
fun FatScreenForm(
    navController: NavController, fatViewModel: FatViewModel
){
    val context = LocalContext.current
    fun navigateToGraph(){
        val points = listOf(
            LineChartData.Point(fatViewModel.text.value.toFloat(), "2016"),
            LineChartData.Point(fatViewModel.text1.value.toFloat(), "2017"),
            LineChartData.Point(fatViewModel.text2.value.toFloat(), "2018"),
            LineChartData.Point(fatViewModel.text3.value.toFloat(), "2019"),
            LineChartData.Point(fatViewModel.text4.value.toFloat(), "2020"),
            LineChartData.Point(fatViewModel.text5.value.toFloat(), "2021"),
            LineChartData.Point(fatViewModel.text6.value.toFloat(), "2022")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("FatGraph/$pointJson")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Input Yearly Number of users with subcutaneous fat")
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = fatViewModel.text.value,
            onValueChange = { fatViewModel.text.value = it },
            label = { Text("2016") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text1.value,
            onValueChange = { fatViewModel.text1.value = it },
            label = { Text("2017") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text2.value,
            onValueChange = { fatViewModel.text2.value = it },
            label = { Text("2018") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text3.value,
            onValueChange = { fatViewModel.text3.value = it },
            label = { Text("2019") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text4.value,
            onValueChange = { fatViewModel.text4.value = it },
            label = { Text("2020") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text5.value,
            onValueChange = { fatViewModel.text5.value = it },
            label = { Text("2021") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text6.value,
            onValueChange = { fatViewModel.text6.value = it },
            label = { Text("2022") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedButton(
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            ),
            onClick = {
                if (fatViewModel.text.value.isEmpty() || fatViewModel.text1.value.isEmpty()
                    || fatViewModel.text2.value.isEmpty() || fatViewModel.text3.value.isEmpty()
                    || fatViewModel.text4.value.isEmpty() || fatViewModel.text5.value.isEmpty()
                    || fatViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get SubCutaneous Fat Graph", style = MaterialTheme.typography.button)
        }
    }
}