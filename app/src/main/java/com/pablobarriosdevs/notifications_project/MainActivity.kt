package com.pablobarriosdevs.notifications_project

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.pablobarriosdevs.notifications_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val channelId = "channelId"
    val channelName = "channelName"

    val notificationId = 0

    companion object{
        const val INTENT_REQUEST = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SecondActivity::class.java)
        val pendingIntent : PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(INTENT_REQUEST, PendingIntent.FLAG_UPDATE_CURRENT)
        }


        val myNotif = CreateNotification(
            context = this,
            channelId = channelId,
            channelName = channelName,
            notificationId = 1
        ) {

            it.setContentTitle("Notificaión de prueba")
            it.setContentText("Mi primera notificación propia")
            it.setSmallIcon(R.drawable.ic_stat_name)
            it.setContentIntent(pendingIntent)
            it.setAutoCancel(true)
            it.priority = NotificationCompat.PRIORITY_HIGH

        }


        myNotif.createNotificationChannel()

        binding.notifBtn.setOnClickListener {
            myNotif.notificationManager.notify(myNotif.notificationId, myNotif.notification)
        }
    }


}