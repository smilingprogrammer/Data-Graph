package com.example.graphdisplay.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.graphdisplay.view.formview.ArterialForm
import com.example.graphdisplay.view.graphs.ArterialGraphView
import com.example.graphdisplay.viewModel.ArterialViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavGraph.ArterialForm.route){
        composable(NavGraph.ArterialForm.route){
            ArterialForm(navController)
        }

        composable(NavGraph.ArterialGraph.route){
            val name = it.arguments?.getString("name")
            ArterialGraphView(name = name)
        }
    }
}
sealed class NavGraph(val route: String){
    object ArterialForm :NavGraph("Arterial")
    object ArterialGraph :NavGraph("ArterialGraph/{name}")
}