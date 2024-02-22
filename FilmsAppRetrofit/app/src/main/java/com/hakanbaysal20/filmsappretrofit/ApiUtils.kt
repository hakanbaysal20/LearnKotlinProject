package com.hakanbaysal20.filmsappretrofit

class ApiUtils {
    companion object{

        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFilmDAOInterface():FilmsDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(FilmsDAOInterface::class.java)
        }
    }
}