package com.example.moontoon.Views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.viewModel_files.ItemsViewModel

@Composable
fun DoneTodoScreen(databaseviewmodel: ItemsViewModel) {
    val check = databaseviewmodel.listofitems.collectAsState(initial = emptyList())


    
}