@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.moontoon

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moontoon.Views.MainScreen
import com.example.moontoon.ui.theme.MoonToonTheme
import com.example.moontoon.viewModel_files.ItemsViewModel
import com.example.moontoon.viewModel_files.NotificationViewModel
import com.example.moontoon.viewModel_files.PermissionViewModel
import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest.Companion.MIN_PERIODIC_INTERVAL_MILLIS
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import java.time.Duration
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val workRequest =  PeriodicWorkRequestBuilder<workerDisplayNotfification>( 15, TimeUnit.MINUTES,
            9, TimeUnit.MINUTES)
            .build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(workRequest)


        setContent {
            //--------------------------------------

         
            //--------------------------------------

            val myview:ItemsViewModel = viewModel()
           val myNotify:NotificationViewModel= viewModel()
           val notifyBuilder=myNotify.getNotificationBuilder()
           val _notifyManager=myNotify.getNotificationManager()
            /**
            val dbitem=Item_Entity(name="Werrt", description = "THA")
            myview.insertItem(dbitem)**/



            MoonToonTheme {
                // A surface container using the 'background' color from the theme
               val permissionViewModel:PermissionViewModel=viewModel()
                val dialogQueue= permissionViewModel.visiblePermissionDialogQueue


                val permissionsState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.POST_NOTIFICATIONS,
                    )
                )

/*
                val lifecycleOwner = LocalLifecycleOwner.current
                DisposableEffect(
                    key1 = lifecycleOwner,
                    effect = {
                        val observer = LifecycleEventObserver { _, event ->
                            if(event == Lifecycle.Event.ON_START) {
                                permissionsState.launchMultiplePermissionRequest()
                            }
                        }
                        lifecycleOwner.lifecycle.addObserver(observer)

                        onDispose {
                            lifecycleOwner.lifecycle.removeObserver(observer)
                        }
                    }
                )
*/

              /*  permissionsState.permissions.forEach { perm ->
                    when(perm.permission) {
                        Manifest.permission.POST_NOTIFICATIONS -> {
                            when {
                                perm.hasPermission -> {
                                    Text(text = "Notification permission accepted")





                                }
                                perm.shouldShowRationale -> {
                                    Text(text = "Camera permission is needed" +
                                            "to access the camera")

                                }
                                perm.isPermanentlyDenied() -> {
                                    Text(text = "Camera permission was permanently" +
                                            "denied. You can enable it in the app" +
                                            "settings.")
                                }
                            }
                        }
                    }
                }*/
//-------------------------------------------------


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //--------------------------



                    //--------------------------

                    var showLandingScreen by remember {
                        mutableStateOf(true)
                    }
                    var   onPermissionGranted by remember {
                        mutableStateOf(false)
                    }



                    if (showLandingScreen) {
                        LandingScreen(onTimeout = { showLandingScreen = false })
                    } else {
                        RuntimePermissionsDialog(Manifest.permission.POST_NOTIFICATIONS,
                            onPermissionGranted = {onPermissionGranted = true})
                        if(onPermissionGranted){
                            MainScreen()
                        }else{
                            Greeting("No Permission")
                        }
                       // MainScreen()
                    }

                }
            }
        }
    }
}



@Composable
fun RuntimePermissionsDialog(
    permission: String,
    onPermissionGranted: () -> Unit
) {

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        if (ContextCompat.checkSelfPermission(
                LocalContext.current,
                permission) != PackageManager.PERMISSION_GRANTED) {

            val requestLocationPermissionLauncher =
                rememberLauncherForActivityResult(
                    ActivityResultContracts.RequestPermission()
                ) { isGranted: Boolean ->

                    if (isGranted) {
                        onPermissionGranted()
                    }
                }

            SideEffect {
                requestLocationPermissionLauncher.launch(permission)
            }
        }
        else{
            onPermissionGranted()

        }
    }else{
        onPermissionGranted()
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