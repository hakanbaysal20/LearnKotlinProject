package com.hakanbaysal20.conditionalnotification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.hakanbaysal20.conditionalnotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonNotification.setOnClickListener {
            val builder:NotificationCompat.Builder
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val intent = Intent(this,MainActivity::class.java)
            val goIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

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
                builder = NotificationCompat.Builder(this,channelId)

                builder.setContentTitle("Başlık")
                    .setContentText("İçerik")
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentIntent(goIntent)
                    .setAutoCancel(true)

            }else{
                builder = NotificationCompat.Builder(this)

                builder.setContentTitle("Başlık İçerik")
                    .setContentText("")
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentIntent(goIntent)
                    .setAutoCancel(true)
                    .priority = Notification.PRIORITY_HIGH
            }
            notificationManager.notify(1,builder.build())
        }
    }
}