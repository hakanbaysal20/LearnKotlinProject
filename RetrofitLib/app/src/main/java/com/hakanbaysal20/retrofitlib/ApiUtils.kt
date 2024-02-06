package com.hakanbaysal20.retrofitlib

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getContactsDaoInterface():ContactsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ContactsDAOInterface::class.java)
        }
    }
}