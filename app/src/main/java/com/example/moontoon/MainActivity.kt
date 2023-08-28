package com.example.moontoon

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
 import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.ui.theme.MoonToonTheme
import com.example.moontoon.viewModel_files.ItemsViewModel
import com.example.moontoon.viewModel_files.NotificationViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val myview:ItemsViewModel = viewModel()
            val myNotify:NotificationViewModel= viewModel()
            val notifyBuilder=myNotify.getNotificationBuilder()
            val _notifyManager=myNotify.getNotificationManager()



            MoonToonTheme {
                // A surface container using the 'background' color from the theme

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

    val itemsShow=databaseviewmodel.listofitems.collectAsState(initial = emptyList())


    Column {
LazyColumn{
    items(itemsShow.value) { _item ->
    Text(
        text = "The added Items ${_item.name}!",
        modifier = modifier
    )
}

}
        Text(
            text = "The added Items ${itemsShow.value}!",
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