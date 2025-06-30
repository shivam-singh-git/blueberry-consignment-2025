package com.example.modernandroidapp.data.workers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.modernandroidapp.R

class ReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val consignmentName = inputData.getString(KEY_CONSIGNMENT_NAME) ?: return Result.failure()
        val itemName = inputData.getString(KEY_ITEM_NAME) ?: return Result.failure()

        showNotification(consignmentName, itemName)

        return Result.success()
    }

    private fun showNotification(consignmentName: String, itemName: String) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "consignment_reminders"
        val channelName = "Consignment Reminders"
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)

        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Consignment Reminder")
            .setContentText("Check on '$itemName' for consignment '$consignmentName'.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }

    companion object {
        const val KEY_CONSIGNMENT_NAME = "key_consignment_name"
        const val KEY_ITEM_NAME = "key_item_name"
    }
} 