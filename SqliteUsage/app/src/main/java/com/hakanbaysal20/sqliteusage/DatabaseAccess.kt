package com.hakanbaysal20.sqliteusage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseAccess(context:Context): SQLiteOpenHelper(context,"contacts",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
    db?.execSQL("CREATE TABLE person (person_no INTEGER PRIMARY KEY AUTOINCREMENT " +
            ",person_name TEXT,person_number TEXT,person_age INTEGER,person_height DOUBLE);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS person")
        onCreate(db)
    }

}