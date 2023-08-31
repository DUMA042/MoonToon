package com.example.moontoon.Usecases

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
        val route: String,
        val title: String,
        val icon: ImageVector
    ) {
        object ToDo : BottomBarScreen(
            route = "To_Do",
            title = "To DO",
            icon = Icons.Default.List
        )

    object ToAdd : BottomBarScreen(
        route = "To_Add",
        title = "To Add",
        icon = Icons.Default.List
    )

        object DoneList : BottomBarScreen(
            route = "Done_List",
            title = "Done",
            icon = Icons.Default.DateRange
        )

        object AboutInfo : BottomBarScreen(
            route = "Info",
            title = "About",
            icon = Icons.Default.Info
        )
    }
