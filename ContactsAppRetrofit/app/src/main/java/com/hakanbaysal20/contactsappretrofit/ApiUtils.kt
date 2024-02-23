package com.hakanbaysal20.contactsappretrofit

class ApiUtils {

    companion object{

        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getContactDaoInterface():ContactsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(ContactsDAOInterface::class.java)
        }
    }
}