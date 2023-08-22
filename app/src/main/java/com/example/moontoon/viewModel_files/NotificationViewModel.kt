package com.example.moontoon.viewModel_files


import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor (
    private val notificationManager:NotificationManagerCompat,
    private val notificationBuilder:NotificationCompat.Builder):
    ViewModel() {

        fun getNotificationBuilder():NotificationCompat.Builder{
         return  notificationBuilder
        }

    fun getNotificationManager():NotificationManagerCompat{
        return  notificationManager
    }

}