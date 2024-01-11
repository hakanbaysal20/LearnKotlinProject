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
    fun getContacts(vba: DatabaseAccess): ArrayList<Person> {
        val contactArrayList = ArrayList<Person>()
        val db = vba.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM person", null)
        val personNoIndex = cursor.getColumnIndex("person_no")
        val personNameIndex = cursor.getColumnIndex("person_name")
        val personNumberIndex = cursor.getColumnIndex("person_number")
        val personAgeIndex = cursor.getColumnIndex("person_age")
        val personHeightIndex = cursor.getColumnIndex("person_height")
        while (cursor.moveToNext()) {
            val person = Person(
                cursor.getInt(personNoIndex),
                cursor.getString(personNameIndex),
                cursor.getString(personNumberIndex),
                cursor.getInt(personAgeIndex),
                cursor.getDouble(personHeightIndex)
            )
            contactArrayList.add(person)
        }
        cursor.close()
        return contactArrayList
    }

    fun updatePerson(db: DatabaseAccess,person: Person) {
        val dba = db.writableDatabase
        val values = ContentValues()
        values.put("person_name",person.person_name)
        values.put("person_number",person.person_number)
        values.put("person_age",person.person_age)
        values.put("person_height",person.person_height)
        dba.update("person",values,"person_no=?", arrayOf(person.person_no.toString()))
        dba.close()
    }
    fun deletePerson(vb:DatabaseAccess,person_no:Int) {
        val dba = vb.writableDatabase
        dba.delete("person","person_no=?", arrayOf(person_no.toString()))
        dba.close()
    }
    fun searchContact(db: DatabaseAccess,keyword:String) : ArrayList<Person> {
        val contactArrayList = ArrayList<Person>()
        val dba = db.writableDatabase
        val cursor = dba.rawQuery("SELECT * FROM person WHERE person_name like '%$keyword%'",null)
        val personNoIndex = cursor.getColumnIndex("person_no")
        val personNameIndex = cursor.getColumnIndex("person_name")
        val personNumberIndex = cursor.getColumnIndex("person_number")
        val personAgeIndex = cursor.getColumnIndex("person_age")
        val personHeightIndex = cursor.getColumnIndex("person_height")
        while (cursor.moveToNext()){
            val person = Person(
                cursor.getInt(personNoIndex),
                cursor.getString(personNameIndex),
                cursor.getString(personNumberIndex),
                cursor.getInt(personAgeIndex),
                cursor.getDouble(personHeightIndex)
            )
            contactArrayList.add(person)
        }
        cursor.close()
        return contactArrayList
    }
    fun getRandom(db: DatabaseAccess) : ArrayList<Person> { // RASTGELE2 VERİ
        val contactArrayList = ArrayList<Person>()
        val dba = db.writableDatabase
        val cursor = dba.rawQuery("SELECT * FROM person ORDER BY RANDOM() LIMIT 2",null)
        val personNoIndex = cursor.getColumnIndex("person_no")
        val personNameIndex = cursor.getColumnIndex("person_name")
        val personNumberIndex = cursor.getColumnIndex("person_number")
        val personAgeIndex = cursor.getColumnIndex("person_age")
        val personHeightIndex = cursor.getColumnIndex("person_height")
        while (cursor.moveToNext()){
            val person = Person(
                cursor.getInt(personNoIndex),
                cursor.getString(personNameIndex),
                cursor.getString(personNumberIndex),
                cursor.getInt(personAgeIndex),
                cursor.getDouble(personHeightIndex)
            )
            contactArrayList.add(person)
        }
        cursor.close()
        return contactArrayList
    }
    fun regisControl(dba:DatabaseAccess,person_name:String):Int {
        var result = 0
        val db = dba.writableDatabase
        val cursor = db.rawQuery("SELECT count(*) AS result FROM person WHERE person_name = '$person_name'",null)
        val resultIndex = cursor.getColumnIndex("result")
        while (cursor.moveToNext()){
            result = cursor.getInt(resultIndex)
        }
        return result
    }
    fun personControl(dba:DatabaseAccess,person_no:Int): Person? {
        var person:Person? = null // gelen kişinin kim olduğunu bilmediğimiz için başta null tanımladık
        val db = dba.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM person WHERE person_no = $person_no",null)
        val personNoIndex = cursor.getColumnIndex("person_no")
        val personNameIndex = cursor.getColumnIndex("person_name")
        val personNumberIndex = cursor.getColumnIndex("person_number")
        val personAgeIndex = cursor.getColumnIndex("person_age")
        val personHeightIndex = cursor.getColumnIndex("person_height")
        while (cursor.moveToNext()){
            person = Person(
                cursor.getInt(personNoIndex),
                cursor.getString(personNameIndex),
                cursor.getString(personNumberIndex),
                cursor.getInt(personAgeIndex),
                cursor.getDouble(personHeightIndex)
            )
        }
        cursor.close()
        return person
    }

}