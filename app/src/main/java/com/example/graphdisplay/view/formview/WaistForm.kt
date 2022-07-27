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
import com.example.graphdisplay.viewModel.WaistViewModel

@Composable
fun WaistForm() {
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
    ) { WaistScreenForm(waistViewModel) }
}

@Composable
fun WaistScreenForm(
    waistViewModel: WaistViewModel
){

    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp
        )
    ) {
        OutlinedTextField(
            value = waistViewModel.text,
            onValueChange = { waistViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text1,
            onValueChange = { waistViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text2,
            onValueChange = { waistViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text3,
            onValueChange = { waistViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text4,
            onValueChange = { waistViewModel.text4 = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text5,
            onValueChange = { waistViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = waistViewModel.text6,
            onValueChange = { waistViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

/*
@Preview
@Composable
fun WaistFormPreview() = WaistForm()*/
