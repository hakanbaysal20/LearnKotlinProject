package com.hakanbaysal20.useofreadydatabase

import java.util.Locale.Category

class Kategorilerdao {

    fun getCategories(vba:DatabaseAccess): ArrayList<Kategoriler> {
        val categoryList = ArrayList<Kategoriler>()
        val vb = vba.writableDatabase
        val cursor = vb.rawQuery("SELECT * FROM kategoriler",null)
        val category_id = cursor.getColumnIndex("kategori_id")
        val category_name = cursor.getColumnIndex("kategori_ad")
        while (cursor.moveToNext()){
            val category = Kategoriler(cursor.getInt(category_id),cursor.getString(category_name))

            categoryList.add(category)
        }
        return  categoryList
    }

}