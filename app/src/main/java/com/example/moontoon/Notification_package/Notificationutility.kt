package com.example.moontoon.Notification_package

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.moontoon.MainActivity

class Notificationutility {

    private companion object {
        private  val PENDING_INTENT_ID = 300
        private val NOTIFICATION_ID = 200
        private val START_NOTI_CHANCEL ="TODO_CHANCEL"



        /*
        fun pending_intent(context:Context){
            var startActivityIntent_todo=Intent(context,MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, startActivityIntent_todo, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
        */


    }





}