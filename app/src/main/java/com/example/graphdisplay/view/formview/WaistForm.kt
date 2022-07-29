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
import com.example.graphdisplay.viewModel.WaistViewModel
import com.google.gson.Gson

@Composable
fun WaistForm(navController: NavController) {
    val waistViewModel = WaistViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "User's Waist Form") }
            )
        },
    ) { WaistScreenForm(navController, waistViewModel) }
}

@Composable
fun WaistScreenForm(
    navController: NavController, waistViewModel: WaistViewModel
){
    val context = LocalContext.current

    fun navigateToGraph(){
        val points = listOf(
            LineChartData.Point(waistViewModel.text.value.toFloat(), "2016"),
            LineChartData.Point(waistViewModel.text1.value.toFloat(), "2017"),
            LineChartData.Point(waistViewModel.text2.value.toFloat(), "2018"),
            LineChartData.Point(waistViewModel.text3.value.toFloat(), "2019"),
            LineChartData.Point(waistViewModel.text4.value.toFloat(), "2020"),
            LineChartData.Point(waistViewModel.text5.value.toFloat(), "2021"),
            LineChartData.Point(waistViewModel.text6.value.toFloat(), "2022")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("WaistGraph/$pointJson")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Input Number of yearly users waist size data")
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = waistViewModel.text.value,
            onValueChange = { waistViewModel.text.value = it },
            label = { Text("2016") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text1.value,
            onValueChange = { waistViewModel.text1.value = it },
            label = { Text("2017") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text2.value,
            onValueChange = { waistViewModel.text2.value = it },
            label = { Text("2018") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text3.value,
            onValueChange = { waistViewModel.text3.value = it },
            label = { Text("2019") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text4.value,
            onValueChange = { waistViewModel.text4.value = it },
            label = { Text("2020") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text5.value,
            onValueChange = { waistViewModel.text5.value = it },
            label = { Text("2021") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text6.value,
            onValueChange = { waistViewModel.text6.value = it },
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
                if (waistViewModel.text.value.isEmpty() || waistViewModel.text1.value.isEmpty()
                    || waistViewModel.text2.value.isEmpty() || waistViewModel.text3.value.isEmpty()
                    || waistViewModel.text4.value.isEmpty() || waistViewModel.text5.value.isEmpty()
                    || waistViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get User's Waist Graph", style = MaterialTheme.typography.button)
        }
    }
}
