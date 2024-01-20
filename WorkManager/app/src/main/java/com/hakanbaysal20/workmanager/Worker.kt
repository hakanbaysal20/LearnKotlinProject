package com.hakanbaysal20.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker(context:Context,workerParams:WorkerParameters):Worker(context,workerParams) {
    override fun doWork(): Result {
        val total = 30 + 20
        Log.e("total",total.toString())

        return Result.success()
    }

}