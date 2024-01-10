package com.hakanbaysal20.sqliteusage

import android.content.ContentValues

class Persondao {
    fun addPerson(vt:DatabaseAccess,person:Person) {
        val db = vt.writableDatabase
        val values = ContentValues()
        values.put("person_name",person.person_name)
        values.put("person_number",person.person_number)
        values.put("person_age",person.person_age)
        values.put("person_height",person.person_height)

        db.insertOrThrow("person",null,values)
        db.close()
    }
    fun deletePerson() {
        
    }
    fun updatePerson() {

    }

}