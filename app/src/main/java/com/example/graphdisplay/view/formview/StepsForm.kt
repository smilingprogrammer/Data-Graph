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
import com.example.graphdisplay.lib.line.LineChartData
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
            LineChartData.Point(stepsViewModel.text.value.toFloat(), "Wk1"),
            LineChartData.Point(stepsViewModel.text1.value.toFloat(), "wk2"),
            LineChartData.Point(stepsViewModel.text2.value.toFloat(), "wk3"),
            LineChartData.Point(stepsViewModel.text3.value.toFloat(), "wk4")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("StepsGraph/$pointJson")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Input Number of weekly users that takes needed steps in a month")
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = stepsViewModel.text.value,
            onValueChange = { stepsViewModel.text.value = it },
            label = { Text("Week1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text1.value,
            onValueChange = { stepsViewModel.text1.value = it },
            label = { Text("Week2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text2.value,
            onValueChange = { stepsViewModel.text2.value = it },
            label = { Text("Week3") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text3.value,
            onValueChange = { stepsViewModel.text3.value = it },
            label = { Text("Week4") },
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
                if (stepsViewModel.text.value.isEmpty() || stepsViewModel.text1.value.isEmpty()
                    || stepsViewModel.text2.value.isEmpty() || stepsViewModel.text3.value.isEmpty()
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
