package com.example.graphdisplay

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItem(){
    Column {
        Card(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {
            Column(
                modifier = Modifier.padding(all = 15.dp)
            ) {
                Text(text =
                "The Probability of dying in the next 10 years from cardiovascular diseases",
                    fontSize = 20.sp)
            }
        }
        Card(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {
            Column(
                modifier = Modifier.padding(all = 15.dp)
            ) {
                Text(text =
                "Chances of getting affected by immunity related diseases in the next 2 years",
                    fontSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
fun ListItemPreview(){
    ListItem()
}