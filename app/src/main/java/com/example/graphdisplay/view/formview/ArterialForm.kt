package com.example.graphdisplay.view.formview

import android.util.Log
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
import com.example.graphdisplay.line.LineChartData.Point
import com.example.graphdisplay.view.ScreenListStatus.navigateHome
import com.example.graphdisplay.viewModel.ArterialViewModel
import com.google.gson.Gson

@Composable
fun ArterialForm(navController: NavController) {
    val arterialViewModel = ArterialViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "Arterial Pressure Form") }
            )
        },
    ) {
        ArterialScreenForm(navController, arterialViewModel)
    }
}

@Composable
fun ArterialScreenForm(
    navController: NavController, arterialViewModel: ArterialViewModel
){
    val context = LocalContext.current

    fun navigateToGraph(){
        val points = listOf(
            Point(arterialViewModel.text.value.toFloat(), "Sun"),
            Point(arterialViewModel.text1.value.toFloat(), "Mon"),
            Point(arterialViewModel.text2.value.toFloat(), "Tue"),
            Point(arterialViewModel.text3.value.toFloat(), "Wed"),
            Point(arterialViewModel.text4.value.toFloat(), "Thur"),
            Point(arterialViewModel.text5.value.toFloat(), "Fri"),
            Point(arterialViewModel.text6.value.toFloat(), "Sat")
        )

        val pointJson = Gson().toJson(points)
        navController.navigate("ArterialGraph/$pointJson")
    }
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Input Number of daily active users")
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(
            value = arterialViewModel.text.value,
            onValueChange = { arterialViewModel.text.value = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text1.value,
            onValueChange = { arterialViewModel.text1.value = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text2.value,
            onValueChange = { arterialViewModel.text2.value = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text3.value,
            onValueChange = { arterialViewModel.text3.value = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text4.value,
            onValueChange = { arterialViewModel.text4.value = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text5.value,
            onValueChange = { arterialViewModel.text5.value = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text6.value,
            onValueChange = { arterialViewModel.text6.value = it },
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
                if (arterialViewModel.text.value.isEmpty() || arterialViewModel.text1.value.isEmpty()
                    || arterialViewModel.text2.value.isEmpty() || arterialViewModel.text3.value.isEmpty()
                    || arterialViewModel.text4.value.isEmpty() || arterialViewModel.text5.value.isEmpty()
                    || arterialViewModel.text6.value.isEmpty()
                ){
                    Toast.makeText(context, "Empty input", Toast.LENGTH_SHORT).show()
                } else{
                    navigateToGraph()
                }
            }
        ) {
            Text(text = "Get Arterial Pressure Graph", style = MaterialTheme.typography.button)
        }
    }
}

//@Preview
//@Composable
//fun ArterialFormPreview() = ArterialForm(arterialViewModel = ArterialViewModel())