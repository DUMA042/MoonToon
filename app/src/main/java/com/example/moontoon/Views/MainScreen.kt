package com.example.moontoon.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.moontoon.Usecases.BottomBarScreen
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moontoon.viewModel_files.ItemsViewModel


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BottomNavGraph1(navController: NavHostController, modifier: Modifier=Modifier) {
/*Box(modifier = modifier.fillMaxSize()) {
    LargeFloatingActionButton(
        onClick =  { navController.navigate("To_Add") {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
        },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp),
    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Navigation Icon"
        )

    }
}*/

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.ToDo.route
    ) {
        composable(route = BottomBarScreen.ToDo.route) {backStackEntry ->
            // Creates a ViewModel from the current BackStackEntry
            // Available in the androidx.hilt:hilt-navigation-compose artifact
            val viewModel = hiltViewModel<ItemsViewModel>()
            Todobody(viewModel)
        }
        composable(route = BottomBarScreen.ToAdd.route) {backStackEntry ->
            // Creates a ViewModel from the current BackStackEntry
            // Available in the androidx.hilt:hilt-navigation-compose artifact
            val viewModel = hiltViewModel<ItemsViewModel>()
            MakeToDoForm(viewModel,navController)
        }

        composable(route = BottomBarScreen.DoneList.route) {backStackEntry ->
            // Creates a ViewModel from the current BackStackEntry
            // Available in the androidx.hilt:hilt-navigation-compose artifact
            val viewModel = hiltViewModel<ItemsViewModel>()
            DoneTodoScreen(viewModel,modifier)
        }
        composable(route = BottomBarScreen.AboutInfo.route) {
            AboutScreen()
        }
    }
}


@Composable
fun MainScreen(modifier:Modifier=Modifier){
    val navController = rememberNavController()

    Scaffold(floatingActionButton = {     FloatingActionButton(
        onClick =  { navController.navigate("To_Add") {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
        },
        modifier = Modifier

    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Navigation Icon"
        )

    }
    },bottomBar = { BottomBar(navController = navController) }) { innerpadding ->
        BottomNavGraph1(navController = navController,Modifier.padding(innerpadding.calculateTopPadding()))

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

@Composable
fun testinghh() {
    Text("ytht")

}