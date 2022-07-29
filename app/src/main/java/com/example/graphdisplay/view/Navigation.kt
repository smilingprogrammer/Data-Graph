package com.example.graphdisplay.view

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.graphdisplay.line.LineChartData.Point
import com.example.graphdisplay.view.formview.*
import com.example.graphdisplay.view.graphs.*
import com.google.gson.Gson

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenList.SelectForm.route){
        composable(ScreenList.SelectForm.route){
            SelectGraphScreen()
            Crossfade(ScreenListStatus.currentChart) { screen ->
                Surface(color = MaterialTheme.colors.background) {
                    when (screen) {
                        ScreenList.ArterialForm -> ArterialForm(navController)
                        ScreenList.DailyForm -> DailyForm(navController)
                        ScreenList.FatForm -> FatForm(navController)
                        ScreenList.StepsForm -> StepsForm(navController)
                        ScreenList.WaistForm -> WaistForm(navController)
                        ScreenList.WeightForm -> WeightForm(navController)
                    }
                }
            }
        }
        composable(ScreenList.ArterialGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                ArterialGraphView(points = (points))
            }
        }
        composable(ScreenList.DailyGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                DailyGraphView(points = (points))
            }
        }
        composable(ScreenList.FatGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                FatGraphView(points = (points))
            }
        }
        composable(ScreenList.StepsGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                StepsGraphView(points = (points))
            }
        }
        composable(ScreenList.WaistGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                WaistGraphView(points = (points))
            }
        }
        composable(ScreenList.WeightGraph.route, arguments = listOf(
            navArgument("points"){
                type = NavType.StringType
            }
        )){ backStackEntry ->
            backStackEntry.arguments?.getString("points")?.let { json ->
                val points: List<Point> = Gson().fromJson(json, Array<Point>::class.java).toList()
                WeightGraphView(points = (points))
            }
        }
    }
}