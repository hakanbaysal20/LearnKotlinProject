package com.hakanbaysal20.bayrakquiz

class Bayraklardao {


    fun getFlagByLimit(vba: DatabaseAccess): ArrayList<Bayraklar> {
        val vb= vba.writableDatabase
        val cursor = vb.rawQuery("SELECT * FROM bayraklar ORDER BY random() LIMIT 5",null)
        val bayrakList = ArrayList<Bayraklar>()
        val bayrak_id = cursor.getColumnIndex("bayrak_id")
        val bayrak_ad = cursor.getColumnIndex("bayrak_ad")
        val bayrak_resim = cursor.getColumnIndex("bayrak_resim")
        while (cursor.moveToNext()){
            val bayrak = Bayraklar(cursor.getInt(bayrak_id),cursor.getString(bayrak_ad),cursor.getString(bayrak_resim))
            bayrakList.add(bayrak)
        }
        return bayrakList
    }
    fun getRandomFlagName(vba:DatabaseAccess,bayrak_id:Int):ArrayList<String> {
        val vb = vba.writableDatabase
        val cursor = vb.rawQuery("SELECT bayrak_ad FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY random() LIMIT 3",null)
        val bayrakAdList = ArrayList<String>()
        val bayrak_ad = cursor.getColumnIndex("bayrak_ad")
        while (cursor.moveToNext()){
            val bayrakAd = cursor.getString(bayrak_ad)
            bayrakAdList.add(bayrakAd)
        }
        return bayrakAdList
    }

}