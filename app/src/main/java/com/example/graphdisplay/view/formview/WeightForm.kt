package com.example.graphdisplay.view.formview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.graphdisplay.view.ScreenListStatus
import com.example.graphdisplay.viewModel.WeightViewModel

@Composable
fun WeightForm() {
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
    ) { WeightScreenForm(weightViewModel) }
}

@Composable
fun WeightScreenForm(
    weightViewModel: WeightViewModel
){

    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp
        )
    ) {
        OutlinedTextField(
            value = weightViewModel.text,
            onValueChange = { weightViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text1,
            onValueChange = { weightViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text2,
            onValueChange = { weightViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text3,
            onValueChange = { weightViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text4,
            onValueChange = { weightViewModel.text4 = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text5,
            onValueChange = { weightViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weightViewModel.text6,
            onValueChange = { weightViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

/*
@Preview
@Composable
fun WeightFormPreview() = WeightForm()*/
