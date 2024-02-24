package com.hakanbaysal20.roomlibusage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class IDatabase:RoomDatabase() {
    abstract fun getContactsDao() : ContactsDao

    companion object{
        var INSTANCE:IDatabase? = null
        fun databaseAccess(context:Context):IDatabase? {
            if (INSTANCE == null){
                synchronized(IDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        IDatabase::class.java,
                        "contacts.sqlite")
                        .createFromAsset("contacts.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}