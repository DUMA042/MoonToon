package com.example.moontoon.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.StabilityInferred
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.moontoon.Usecases.BottomBarScreen

@Composable
fun AboutScreen() {
   val screens = listOf(
      BottomBarScreen.ToDo,
      BottomBarScreen.DoneList,
      BottomBarScreen.AboutInfo,
      BottomBarScreen.ToAdd
   )

   Column {
      screens.forEach{icondescriptiontheme->
         givedetails(icondescription = icondescriptiontheme)

      }
      Text("The Image Icon used in the Application splash Screen are from Icon8.com")
   }


}


@Composable
fun givedetails(icondescription:BottomBarScreen) {
   Row{
      Icon(
         imageVector = icondescription.icon,
         contentDescription = "Icon"
      )

      Text(icondescription.iconDescription)

   }



}