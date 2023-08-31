@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.moontoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.Views.MainScreen
import com.example.moontoon.ui.theme.MoonToonTheme
import com.example.moontoon.viewModel_files.ItemsViewModel
import com.example.moontoon.viewModel_files.NotificationViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val myview:ItemsViewModel = viewModel()
            val myNotify:NotificationViewModel= viewModel()
            val notifyBuilder=myNotify.getNotificationBuilder()
            val _notifyManager=myNotify.getNotificationManager()
            /**
            val dbitem=Item_Entity(name="Werrt", description = "THA")
            myview.insertItem(dbitem)**/



            MoonToonTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showLandingScreen by remember {
                        mutableStateOf(true)
                    }
                    if (showLandingScreen) {
                        LandingScreen(onTimeout = { showLandingScreen = false })
                    } else {
                        MainScreen()
                    }

                }
            }
        }
    }
}


@Composable
fun  LandingScreen(onTimeout: () -> Unit,modifier:Modifier=Modifier) {
    val currentonTimeOut by rememberUpdatedState(newValue = onTimeout)

    Box(modifier = Modifier.fillMaxSize()){
        LaunchedEffect(Unit){
            delay(400L)
             currentonTimeOut()
        }
        Image(
            painter = painterResource(R.drawable.nav_home_select),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.Center)
                .size(100.dp)
                .clip(CircleShape)
        )
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