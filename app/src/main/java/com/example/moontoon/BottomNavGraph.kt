package com.example.moontoon


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moontoon.Usecases.BottomBarScreen
import com.example.moontoon.Views.AboutScreen
import com.example.moontoon.Views.DoneTodoScreen
import com.example.moontoon.Views.Todobody

/*
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.ToDo.route
    ) {
        composable(route = BottomBarScreen.ToDo.route) {
            Todobody()
        }
        composable(route = BottomBarScreen.DoneList.route) {
            DoneTodoScreen()
        }
        composable(route = BottomBarScreen.AboutInfo.route) {
            AboutScreen()
        }
    }
}

 */