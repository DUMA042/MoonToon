package com.example.moontoon.Usecases

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector



sealed class BottomBarScreen(
        val route: String,
        val title: String,
        val iconDescription: String,
        val icon: ImageVector
    ) {
        object ToDo : BottomBarScreen(
            route = "To_Do",
            title = "To DO",
            iconDescription="For All the To Do you have Created",
            icon = Icons.Default.List
        )

    object ToAdd : BottomBarScreen(
        route = "To_Add",
        title = "To Add",
        iconDescription="Press when you want to create new To Do",
        icon = Icons.Default.List
    )

        object DoneList : BottomBarScreen(
            route = "Done_List",
            title = "Done",
            iconDescription="Location where you can see all the activities you have marked as done",
            icon = Icons.Default.DateRange
        )

        object AboutInfo : BottomBarScreen(
            route = "Info",
            title = "About",
            iconDescription="This is the about page for the Application",
            icon = Icons.Default.Info
        )
    }
