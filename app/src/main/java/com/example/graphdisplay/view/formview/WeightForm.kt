package com.example.graphdisplay.view.formview

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import com.example.graphdisplay.viewModel.WeightViewModel
import com.google.gson.Gson

@Composable
fun WeightForm(navController: NavController) {
    val weightViewModel = WeightViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "User's Weight Form") }
            )
        },
    ) { WeightScreenForm(navController, weightViewModel) }
}

@Composable
fun WeightScreenForm(
    navController: NavController,weightViewModel: WeightViewModel
){
    val context = LocalContext.current

    fun navigateToGraph(){
        val points = listOf(
            LineChartData.Point(weightViewModel.text.value.toFloat(), "Sun"),
            LineChartData.Point(weightViewModel.text1.value.toFloat(), "Mon"),
            LineChartData.Point(weightViewModel.text2.value.toFloat(), "Tue"),
            LineChartData.Point(weightViewModel.text3.value.toFloat(), "Wed"),
            LineChartData.Point(weightViewModel.text4.value.toFloat(), "Thur"),
            LineChartData.Point(weightViewModel.text5.value.toFloat(), "Fri"),
            LineChartData.Point(weightViewModel.text6.value.toFloat(), "Sat")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("WeightGraph/$pointJson")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = weightViewModel.text.value,
            onValueChange = { weightViewModel.text.value = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text1.value,
            onValueChange = { weightViewModel.text1.value = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text2.value,
            onValueChange = { weightViewModel.text2.value = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text3.value,
            onValueChange = { weightViewModel.text3.value = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text4.value,
            onValueChange = { weightViewModel.text4.value = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text5.value,
            onValueChange = { weightViewModel.text5.value = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text6.value,
            onValueChange = { weightViewModel.text6.value = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedButton(
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color.White),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            ),
            onClick = {
                if (weightViewModel.text.value.isEmpty() || weightViewModel.text1.value.isEmpty()
                    || weightViewModel.text2.value.isEmpty() || weightViewModel.text3.value.isEmpty()
                    || weightViewModel.text4.value.isEmpty() || weightViewModel.text5.value.isEmpty()
                    || weightViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get User's Weight Graph", style = MaterialTheme.typography.button)
        }
    }
}
