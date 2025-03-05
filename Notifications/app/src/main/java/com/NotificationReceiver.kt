package com

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.megha.notifications.R

class NotificationReceiver : BroadcastReceiver() {
    private  val channelId="1"
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null){

        val builder = NotificationCompat.Builder(context,channelId)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(channelId,"1", NotificationManager.IMPORTANCE_HIGH)
            val manager : NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
            builder.setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Title")
                .setContentText("Notification Text")
        }
        else{
            builder.setSmallIcon(R.drawable.small_icon)
                .setContentText("Notification Title")
                .setContentText("This is the notification text")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        }
        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(1,builder.build())
    }
    }
}