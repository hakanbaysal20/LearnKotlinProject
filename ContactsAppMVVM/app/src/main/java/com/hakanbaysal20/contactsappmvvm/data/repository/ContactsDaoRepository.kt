package com.hakanbaysal20.contactsappmvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hakanbaysal20.contactsappmvvm.data.entity.CrudResponse
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.data.entity.PersonResponse
import com.hakanbaysal20.contactsappmvvm.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsDaoRepository() {
    var personsList:MutableLiveData<List<Person>>
    init {
        personsList = MutableLiveData()
    }
    fun addPersonButton(personName:String,personNumber:String) {
       val contactIDF = ApiUtils.getContactsDaoInterface()
        contactIDF.addPerson(personName,personNumber).enqueue(object : Callback<CrudResponse>{
            override fun onResponse(call: Call<CrudResponse>?, response: Response<CrudResponse>) {
                Log.e("success","${response.body().success.toString()} - ${response.body().message}")
            }
            override fun onFailure(call: Call<CrudResponse>?, t: Throwable?) {

            }
        })
    }
    fun updateButton(personId:Int,personName:String,personNo:String) {
       val contactsIDF = ApiUtils.getContactsDaoInterface()
        contactsIDF.updatePerson(personId,personName,personNo)
            .enqueue(object : Callback<CrudResponse>{
                override fun onResponse(
                    call: Call<CrudResponse>?,
                    response: Response<CrudResponse>
                ) {
                    Log.e("success","${response.body().success.toString()} - ${response.body().message}")
                }

                override fun onFailure(call: Call<CrudResponse>?, t: Throwable?) {

                }
            })
    }
    fun searchPerson(word:String) {
        val contactsIDF = ApiUtils.getContactsDaoInterface()
        contactsIDF.searchPerson(word).enqueue(object : Callback<PersonResponse>{
            override fun onResponse(
                call: Call<PersonResponse>?,
                response: Response<PersonResponse>
            ) {
               personsList.value = response.body().contactsList
            }

            override fun onFailure(call: Call<PersonResponse>?, t: Throwable?) {

            }
        })
    }
    fun deletePerson(personId:Int) {
        val contactsIDF = ApiUtils.getContactsDaoInterface()
        contactsIDF.deletePerson(personId)
            .enqueue(object : Callback<CrudResponse>{
                override fun onResponse(
                    call: Call<CrudResponse>?,
                    response: Response<CrudResponse>
                ) {
                    Log.e("success","${response.body().success.toString()} - ${response.body().message}")
                    getContacts()
                }
                override fun onFailure(call: Call<CrudResponse>?, t: Throwable?) {

                }
            })

    }
    fun getContacts() {
        val contactsIDF = ApiUtils.getContactsDaoInterface()
        contactsIDF.getContacts().enqueue(object : Callback<PersonResponse>{
            override fun onResponse(
                call: Call<PersonResponse>?,
                response: Response<PersonResponse>
            ) {
                personsList.value = response.body().contactsList
            }

            override fun onFailure(call: Call<PersonResponse>?, t: Throwable?) {

            }
        })
    }
    fun getContactsVM():MutableLiveData<List<Person>> {
        return personsList
    }
}