package com.example.moontoon.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.moontoon.Dao_Interfaces.Items_Data_BaseDao
import com.example.moontoon.Repositories.ItemRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Notification_di {

    @Singleton
    @Provides
    fun provideNotificationBuilder(@ApplicationContext context: Context): NotificationCompat.Builder{
        return NotificationCompat.Builder(context,"NOTIFICATION_CHANNEL_ID")
            .setContentTitle("TODO")
            .setContentText("You have work to do")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    }


    @Singleton
    @Provides
    fun provideNotificationManager(@ApplicationContext context: Context,notificationBuilder:NotificationCompat.Builder): NotificationManagerCompat{
       // val notificationManager1= getSystemService
        val notificationManager=NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel= NotificationChannel("NOTIFICATION_CHANNEL_ID","TO DO NOTIFY", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)

        }

        return notificationManager

    }

}