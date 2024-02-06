package com.hakanbaysal20.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.hakanbaysal20.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
        /*    val condition = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val request = OneTimeWorkRequestBuilder<Worker>().setInitialDelay(10,TimeUnit.SECONDS).setConstraints(condition).build()
            WorkManager.getInstance(this).enqueue(request)*/
            val request = PeriodicWorkRequestBuilder<WorkerNotification>(15,TimeUnit.MINUTES).setInitialDelay(10,TimeUnit.SECONDS).build()
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
                .observe(this){
                    val status = it.state.name
                    Log.e("asdasd",status)
                }

        }
    }
}