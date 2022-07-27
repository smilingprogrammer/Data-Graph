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
import com.example.graphdisplay.viewModel.DailyViewModel

@Composable
fun DailyForm() {
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
    ) { DailyScreenForm(dailyViewModel) }
}

@Composable
fun DailyScreenForm(
    dailyViewModel: DailyViewModel
){

    Column(
        modifier = Modifier.padding(
            horizontal = 8.dp
        )
    ) {
        OutlinedTextField(
            value = dailyViewModel.text,
            onValueChange = { dailyViewModel.text = it },
            label = { Text("Sunday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text1,
            onValueChange = { dailyViewModel.text1 = it },
            label = { Text("Monday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text2,
            onValueChange = { dailyViewModel.text2 = it },
            label = { Text("Tuesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text3,
            onValueChange = { dailyViewModel.text3 = it },
            label = { Text("Wednesday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text4,
            onValueChange = { dailyViewModel.text = it },
            label = { Text("Thursday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text5,
            onValueChange = { dailyViewModel.text5 = it },
            label = { Text("Friday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = dailyViewModel.text6,
            onValueChange = { dailyViewModel.text6 = it },
            label = { Text("Saturday") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

//@Preview
//@Composable
//fun DailyFormPreview() = DailyForm()