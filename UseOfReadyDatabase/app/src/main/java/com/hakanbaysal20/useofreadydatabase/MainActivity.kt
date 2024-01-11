package com.hakanbaysal20.useofreadydatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.useofreadydatabase.FilmlerDao.Filmlerdao
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         copyDatabase()
        val vba = DatabaseAccess(this)
    //    val list = Kategorilerdao().getCategories(vba)
        val liste = Filmlerdao().tumFilmlerByKategoriId(vba,2)
        for(i in liste){
            Log.e("Film adı",i.film_ad)
            Log.e("Film id",i.film_id.toString())
            Log.e("Film yıl ",i.film_yil.toString())
            Log.e("Film resim",i.film_resim)
            Log.e("Kategori id",i.kategori.kategori_id.toString())
            Log.e("Kategori ad",i.kategori.kategori_ad)
            Log.e("Yönetmen id",i.yonetmen.yonetmen_id.toString())
            Log.e("Yönetmen ad",i.yonetmen.yonetmen_ad)
        }
    }
    fun copyDatabase() {
        val db = DatabaseCopyHelper(this)

       try {
           db.createDataBase()

       }catch (e:Exception){
           e.printStackTrace()
       }
        try {
            db.openDataBase()


        }catch (e:Exception){
            e.printStackTrace()
        }


    }
}