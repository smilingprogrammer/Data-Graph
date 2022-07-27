package com.example.graphdisplay.view.formview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.graphdisplay.view.ScreenListStatus.navigateHome
import com.example.graphdisplay.viewModel.ArterialViewModel

@Composable
fun ArterialForm(navController: NavController) {
    val arterialViewModel = ArterialViewModel()
    var dummyValue = remember {
        mutableStateOf("")
    }
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

        TextField(value = dummyValue.value, onValueChange = {
            dummyValue.value = it
        })
        ArterialScreenForm(arterialViewModel)
        OutlinedButton(
            modifier = Modifier
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color.White),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            ),

            onClick = { navController.navigate("ArterialGraph/${dummyValue.value}") }
        ) {
            Text(text = "Arterial Graph", style = MaterialTheme.typography.button)
        }
    }
}

@Composable
fun ArterialScreenForm(
    arterialViewModel: ArterialViewModel
){
    Column(
        modifier = Modifier.padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = arterialViewModel.text,
            onValueChange = { arterialViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text1,
            onValueChange = { arterialViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text2,
            onValueChange = { arterialViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text3,
            onValueChange = { arterialViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text4,
            onValueChange = { arterialViewModel.text4 = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text5,
            onValueChange = { arterialViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = arterialViewModel.text6,
            onValueChange = { arterialViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

//@Preview
//@Composable
//fun ArterialFormPreview() = ArterialForm(arterialViewModel = ArterialViewModel())