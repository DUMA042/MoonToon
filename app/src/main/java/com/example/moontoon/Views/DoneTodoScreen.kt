package com.example.moontoon.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.viewModel_files.ItemsViewModel

@Composable
fun DoneTodoScreen(databaseviewmodel: ItemsViewModel,modifier:Modifier = Modifier) {
    val saved = databaseviewmodel.listofitems.collectAsState(initial = emptyList())
    val _saved = saved.value.filter { it.doneTime!=it.madeTime }

    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(
            items = _saved,
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            key = { task -> task.uid }
        ) { task ->
            ElevatedCardExample(databaseviewmodel,task)
        }
        item{Spacer(modifier = Modifier.padding(35.dp))}

        //ElevatedCardExample()



    }




    
}