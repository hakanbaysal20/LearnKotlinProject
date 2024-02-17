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
        //addUser()
        //updateUser()
        //getContacts()
        searchContacts()
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
    fun updateUser() {
        val cdi = ApiUtils.getContactsDaoInterface()
        cdi.updateUser(16760,"HakanBaysal","55525252").enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                if (response != null){
                    Log.e("Success",response.body()!!.success.toString())
                    Log.e("Message",response.body()!!.message)
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }
        })
    }
    fun getContacts() {
        val cdi = ApiUtils.getContactsDaoInterface()
        cdi.getContacts().enqueue(object :Callback<ContactsResponse>{
            override fun onResponse(
                call: Call<ContactsResponse>?,
                response: Response<ContactsResponse>?
            ) {
                if (response != null){
                    val contactList = response.body()!!.contacts
                    for (i in contactList){
                        Log.e("id",i.kisiId.toString())
                        Log.e("ad",i.kisiAd)
                        Log.e("tel",i.kisiTel)
                    }
                }
            }

            override fun onFailure(call: Call<ContactsResponse>, t: Throwable) {
            }
        })
    }
    fun searchContacts() {
        val cdi = ApiUtils.getContactsDaoInterface()
        cdi.searchContacts("Hakan").enqueue(object :Callback<ContactsResponse>{
            override fun onResponse(
                call: Call<ContactsResponse>?,
                response: Response<ContactsResponse>?
            ) {
                if (response != null){
                    val contactList = response.body()!!.contacts
                    for (i in contactList){
                        Log.e("id",i.kisiId.toString())
                        Log.e("ad",i.kisiAd)
                        Log.e("tel",i.kisiTel)
                    }
                }
            }
            override fun onFailure(call: Call<ContactsResponse>, t: Throwable) {

            }
        })
    }
}