package com.hakanbaysal20.useofreadydatabase.FilmlerDao

import android.annotation.SuppressLint
import com.hakanbaysal20.useofreadydatabase.DatabaseAccess
import com.hakanbaysal20.useofreadydatabase.Filmler
import com.hakanbaysal20.useofreadydatabase.Kategoriler
import com.hakanbaysal20.useofreadydatabase.Yonetmenler

class Filmlerdao {



    fun tumFilmlerByKategoriId(vt:DatabaseAccess, kategori_id:Int) : ArrayList<Filmler> {

        val filmlerListe = ArrayList<Filmler>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM filmler,kategoriler,yonetmenler WHERE filmler.kategori_id = kategoriler.kategori_id and filmler.yonetmen_id = yonetmenler.yonetmen_id and filmler.kategori_id = $kategori_id",null)

        val kategoriId = cursor.getColumnIndex("kategori_id")
        val kategoriAd = cursor.getColumnIndex("kategori_ad")
        val yonetmenId = cursor.getColumnIndex("yonetmen_id")
        val yonetmenAd = cursor.getColumnIndex("yonetmen_ad")
        val filmId = cursor.getColumnIndex("film_id")
        val filmYil = cursor.getColumnIndex("film_yil")
        val filmAd = cursor.getColumnIndex("film_ad")
        val filmResim = cursor.getColumnIndex("film_resim")

        while(cursor.moveToNext()){

            val kategori = Kategoriler(cursor.getInt(kategoriId)
                ,cursor.getString(kategoriAd))

            val yonetmen = Yonetmenler(cursor.getInt(yonetmenId)
                ,cursor.getString(yonetmenAd))

            val film = Filmler(cursor.getInt(filmId)
                ,cursor.getString(filmAd)
                ,cursor.getInt(filmYil)
                ,cursor.getString(filmResim),kategori,yonetmen)

            filmlerListe.add(film)

        }

        return filmlerListe
    }

}