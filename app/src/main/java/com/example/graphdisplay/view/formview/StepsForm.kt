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
import com.example.graphdisplay.view.ScreenListStatus
import com.example.graphdisplay.viewModel.StepsViewModel

@Composable
fun StepsForm() {
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
    ) { StepsScreenForm(stepsViewModel) }
}

@Composable
fun StepsScreenForm(
    stepsViewModel: StepsViewModel
){

    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp
        )
    ) {
        OutlinedTextField(
            value = stepsViewModel.text,
            onValueChange = { stepsViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text1,
            onValueChange = { stepsViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text2,
            onValueChange = { stepsViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text3,
            onValueChange = { stepsViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text4,
            onValueChange = { stepsViewModel.text4 = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text5,
            onValueChange = { stepsViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = stepsViewModel.text6,
            onValueChange = { stepsViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

/*
@Preview
@Composable
fun StepsFormPreview() = StepsForm()*/
