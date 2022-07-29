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
import com.example.graphdisplay.viewModel.StepsViewModel
import com.google.gson.Gson

@Composable
fun StepsForm(navController: NavController) {
    val stepsViewModel = StepsViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "User's Steps Form") }
            )
        },
    ) { StepsScreenForm(navController, stepsViewModel) }
}

@Composable
fun StepsScreenForm(
    navController: NavController, stepsViewModel: StepsViewModel
){
    val context = LocalContext.current
    fun navigateToGraph(){
        val points = listOf(
            LineChartData.Point(stepsViewModel.text.value.toFloat(), "Sun"),
            LineChartData.Point(stepsViewModel.text1.value.toFloat(), "Mon"),
            LineChartData.Point(stepsViewModel.text2.value.toFloat(), "Tue"),
            LineChartData.Point(stepsViewModel.text3.value.toFloat(), "Wed"),
            LineChartData.Point(stepsViewModel.text4.value.toFloat(), "Thur"),
            LineChartData.Point(stepsViewModel.text5.value.toFloat(), "Fri"),
            LineChartData.Point(stepsViewModel.text6.value.toFloat(), "Sat")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("StepsGraph/$pointJson")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = stepsViewModel.text.value,
            onValueChange = { stepsViewModel.text.value = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text1.value,
            onValueChange = { stepsViewModel.text1.value = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text2.value,
            onValueChange = { stepsViewModel.text2.value = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text3.value,
            onValueChange = { stepsViewModel.text3.value = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text4.value,
            onValueChange = { stepsViewModel.text4.value = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text5.value,
            onValueChange = { stepsViewModel.text5.value = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text6.value,
            onValueChange = { stepsViewModel.text6.value = it },
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
                if (stepsViewModel.text.value.isEmpty() || stepsViewModel.text1.value.isEmpty()
                    || stepsViewModel.text2.value.isEmpty() || stepsViewModel.text3.value.isEmpty()
                    || stepsViewModel.text4.value.isEmpty() || stepsViewModel.text5.value.isEmpty()
                    || stepsViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get User's Steps Graph", style = MaterialTheme.typography.button)
        }
    }
}

/*
@Preview
@Composable
fun StepsFormPreview() = StepsForm()*/
