package com.hakanbaysal20.notesappretrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getNoteDAOInterface():NotesDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(NotesDAOInterface::class.java)
        }
    }
}