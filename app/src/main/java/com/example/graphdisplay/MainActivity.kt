package com.example.graphdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.graphdisplay.ui.theme.GraphDisplayTheme
import com.example.graphdisplay.view.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {
            Navigation()
        }
    }
}