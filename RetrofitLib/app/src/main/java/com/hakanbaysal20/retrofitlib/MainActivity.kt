package com.hakanbaysal20.retrofitlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //deleteUser()
        addUser()


    }
    fun deleteUser() {
        val cdi =ApiUtils.getContactsDaoInterface()
        cdi.deleteUser(16759).enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                if (response != null){
                    Log.e("Success",response.body()!!.success.toString())
                    Log.e("Message",response.body()!!.message)
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
            }
        })

    }
    fun addUser() {
        val cdi = ApiUtils.getContactsDaoInterface()
        cdi.addUser("Ahmet","222222").enqueue(object :Callback<CRUDResponse>{

            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {

                if (response != null){
                    Log.e("Success",response.body()!!.success.toString())
                    Log.e("Message",response.body()!!.message)
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
            }
        })
    }
}