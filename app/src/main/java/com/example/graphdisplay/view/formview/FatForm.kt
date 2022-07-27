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
import com.example.graphdisplay.viewModel.FatViewModel

@Composable
fun FatForm() {
    val fatViewModel = FatViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { ScreenListStatus.navigateHome() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
                    }
                },
                title = { Text(text = "Subcutaneous Fat Form") }
            )
        },
    ) { FatScreenForm(fatViewModel) }
}

@Composable
fun FatScreenForm(
    fatViewModel: FatViewModel
){

    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp
        )
    ) {
        OutlinedTextField(
            value = fatViewModel.text,
            onValueChange = { fatViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text1,
            onValueChange = { fatViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text2,
            onValueChange = { fatViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text3,
            onValueChange = { fatViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text4,
            onValueChange = { fatViewModel.text4 = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text5,
            onValueChange = { fatViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = fatViewModel.text6,
            onValueChange = { fatViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

//@Preview
//@Composable
//fun FatFormPreview() = FatForm()