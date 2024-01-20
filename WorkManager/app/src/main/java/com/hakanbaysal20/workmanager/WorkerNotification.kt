package com.hakanbaysal20.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerNotification(context:Context,workerParams:WorkerParameters):Worker(context,workerParams) {
    override fun doWork(): Result {
        createNotification()
        return Result.success()
    }
    fun createNotification() {
        val builder:NotificationCompat.Builder
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(applicationContext,MainActivity::class.java)
        val goIntent = PendingIntent.getActivity(applicationContext,1,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId = "channelId"
            val channel_name = "channel_name"
            val channel_intro = "channel_intro"
            val channel_priority = NotificationManager.IMPORTANCE_HIGH

            var channel : NotificationChannel? = notificationManager.getNotificationChannel(channelId)
            if (channel == null){
                channel = NotificationChannel(channelId,channel_name,channel_priority)
                channel.description = channel_intro
                notificationManager.createNotificationChannel(channel)
            }
            builder = NotificationCompat.Builder(applicationContext,channelId)

            builder.setContentTitle("Başlık")
                .setContentText("İçerik")
                .setSmallIcon(R.drawable.im_gift)
                .setContentIntent(goIntent)
                .setAutoCancel(true)

        }else{
            builder = NotificationCompat.Builder(applicationContext)

            builder.setContentTitle("Başlık İçerik")
                .setContentText("")
                .setSmallIcon(R.drawable.im_gift)
                .setContentIntent(goIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }
        notificationManager.notify(1,builder.build())

    }
}
