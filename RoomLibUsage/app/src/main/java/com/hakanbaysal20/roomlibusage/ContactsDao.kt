package com.hakanbaysal20.roomlibusage

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ContactsDao {
    @Query("SELECT * FROM persons")
    suspend fun getContacts() : List<Person>
}