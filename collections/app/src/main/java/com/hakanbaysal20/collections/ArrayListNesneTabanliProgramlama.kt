package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val u1 = Urun(1,"Saat",150.0)
    val u2 = Urun(2,"TV",1500.0)
    val u3 = Urun(3,"Telefon",1000.0)
    val u4 = Urun(4,"Kolye",100.0)
    val u5 = Urun(5,"Bilgisayar",1500.0)
    val urunler = ArrayList<Urun>()
    urunler.add(u1)
    urunler.add(u2)
    urunler.add(u3)
    urunler.add(u4)
    urunler.add(u5)


    for (urun in urunler){
        println("Ürün no : ${urun.urunNo}")
        println("Ürün adı : ${urun.urunAdı}")
        println("Ürün fiyatı : ${urun.urunFiyati}")
        println("*************")

    }

}