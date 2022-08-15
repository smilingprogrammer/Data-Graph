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
import com.example.graphdisplay.viewModel.DailyViewModel
import com.google.gson.Gson

@Composable
fun DailyForm(navController: NavController) {
    val dailyViewModel = DailyViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "Daily Activity Form") }
            )
        },
    ) { DailyScreenForm(navController, dailyViewModel) }
}

@Composable
fun DailyScreenForm(
    navController: NavController,dailyViewModel: DailyViewModel
){
    val context = LocalContext.current
    fun navigateToGraph(){
        val points = listOf(
            LineChartData.Point(dailyViewModel.text.value.toFloat(), "Sun"),
            LineChartData.Point(dailyViewModel.text1.value.toFloat(), "Mon"),
            LineChartData.Point(dailyViewModel.text2.value.toFloat(), "Tue"),
            LineChartData.Point(dailyViewModel.text3.value.toFloat(), "Wed"),
            LineChartData.Point(dailyViewModel.text4.value.toFloat(), "Thur"),
            LineChartData.Point(dailyViewModel.text5.value.toFloat(), "Fri"),
            LineChartData.Point(dailyViewModel.text6.value.toFloat(), "Sat")
        )
        val pointJson = Gson().toJson(points)
        navController.navigate("DailyGraph/$pointJson")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Input Number of daily active users")
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = dailyViewModel.text.value,
            onValueChange = { dailyViewModel.text.value = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text1.value,
            onValueChange = { dailyViewModel.text1.value = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text2.value,
            onValueChange = { dailyViewModel.text2.value = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text3.value,
            onValueChange = { dailyViewModel.text3.value = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text4.value,
            onValueChange = { dailyViewModel.text4.value = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text5.value,
            onValueChange = { dailyViewModel.text5.value = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text6.value,
            onValueChange = { dailyViewModel.text6.value = it },
            label = { Text("Saturday") },
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
                if (dailyViewModel.text.value.isEmpty() || dailyViewModel.text1.value.isEmpty()
                    || dailyViewModel.text2.value.isEmpty() || dailyViewModel.text3.value.isEmpty()
                    || dailyViewModel.text4.value.isEmpty() || dailyViewModel.text5.value.isEmpty()
                    || dailyViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get DailyActivity Graph", style = MaterialTheme.typography.button)
        }
    }
}