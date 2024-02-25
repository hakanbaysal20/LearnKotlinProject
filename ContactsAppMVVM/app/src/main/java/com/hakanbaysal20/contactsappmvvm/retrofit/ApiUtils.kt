package com.hakanbaysal20.contactsappmvvm.retrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getContactsDaoInterface(): ContactsDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(ContactsDaoInterface::class.java)
        }
    }
}