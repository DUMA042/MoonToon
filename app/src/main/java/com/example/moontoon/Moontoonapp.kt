package com.example.moontoon

import android.app.Application
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Moontoonapp: Application() , Configuration.Provider {

    @Inject
    lateinit var workerFactory: customworkerFactory

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}

class customworkerFactory @Inject constructor(private val notificationManager: NotificationManagerCompat,
                                              private val notificationBuilder: NotificationCompat.Builder): WorkerFactory(){
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return workerDisplayNotfification(appContext,workerParameters,notificationManager,notificationBuilder)

    }


}