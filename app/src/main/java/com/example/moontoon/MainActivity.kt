package com.example.moontoon

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.Data_Entities.Item_Entity
import com.example.moontoon.ui.theme.MoonToonTheme
import com.example.moontoon.viewModel_files.ItemsViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoonToonTheme {
                // A surface container using the 'background' color from the theme
                val myview:ItemsViewModel = viewModel()
                val item_entity=Item_Entity(name="Name1", description = "hfurjr")
                val item_entity1=Item_Entity(name="Name2", description = "YUISS")
                myview.insertItem(item_entity)
                myview.insertItem(item_entity1)




                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, databaseviewmodel:ItemsViewModel= viewModel(), modifier: Modifier = Modifier) {

    val items_Show=databaseviewmodel.listofitems.collectAsState(initial = 0)

    Column {
        Text(
            text = "The added Items ${items_Show.value}!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoonToonTheme {
        Greeting("Android")
    }
}