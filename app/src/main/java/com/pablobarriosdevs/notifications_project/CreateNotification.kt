package com.pablobarriosdevs.notifications_project

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService


class CreateNotification(
    private val context: Context,
    val channelId :String = "channelId",
    val channelName:String = "channelName",
    val notificationId : Int = 0,
    val createNotification : (NotificationCompat.Builder)->Unit
) {

    val notificationManager = NotificationManagerCompat.from(context)

    val notification = NotificationCompat.Builder(context, channelId).also {
        createNotification(it)
    }.build()

     fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                lightColor = Color.RED
                enableLights(true)
            }

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }


}