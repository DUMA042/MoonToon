package com.example.moontoon.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moontoon.ui.theme.Purple40
import com.example.moontoon.ui.theme.PurpleGrey80
import com.example.moontoon.viewModel_files.ItemsViewModel
import kotlin.math.roundToInt


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BottomNavGraph1(navController: NavHostController, modifier: Modifier=Modifier) {

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


    Scaffold(  topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "MoonToon",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }, backgroundColor = Color(Purple40.value),
            modifier = Modifier
                .fillMaxWidth()

        )
    },floatingActionButton = {  LargeFloatingActionButton(
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
//---------------------------------------------------------

    NavigationBar(containerColor = Purple40,modifier = Modifier.fillMaxWidth()) {
        screens.forEach { replyDestination ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == replyDestination.route
                } == true,
                onClick = {
                    navController.navigate(replyDestination.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = replyDestination.icon,
                        contentDescription = "ICON"
                    )
                }
            )
        }
    }

//-------------------------------------------------------
    /*
    BottomNavigation(
        modifier = Modifier
            .background(MaterialTheme.colors.primary) // Change the background color here
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

     */
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