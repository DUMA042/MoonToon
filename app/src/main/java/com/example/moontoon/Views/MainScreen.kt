package com.example.moontoon.Views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moontoon.BottomNavGraph
import com.example.moontoon.Usecases.BottomBarScreen
import androidx.compose.material.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moontoon.viewModel_files.ItemsViewModel


@Composable
fun BottomNavGraph1(navController: NavHostController, modifier: Modifier=Modifier) {
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


@Composable
fun MainScreen(){
    val navController = rememberNavController()
   Scaffold( bottomBar = { BottomBar(navController = navController) }) {innerpadding ->
       BottomNavGraph1(navController = navController,Modifier.padding(innerpadding))
   }

}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.ToDo,
        BottomBarScreen.DoneList,
        BottomBarScreen.AboutInfo,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}