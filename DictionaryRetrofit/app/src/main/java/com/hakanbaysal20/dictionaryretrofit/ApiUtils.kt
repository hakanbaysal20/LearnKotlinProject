package com.hakanbaysal20.dictionaryretrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getWordDAOInterface():WordsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(WordsDAOInterface::class.java)
        }
    }
}