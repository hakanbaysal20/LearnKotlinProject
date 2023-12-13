package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val ogrenci1 = Ogrenci(1,"Ahmet","11A")
    val ogrenci2 = Ogrenci(2,"Fatma","12B")
    val ogrenci3 = Ogrenci(3,"Hayriye","10C")
    val ogrenci4 = Ogrenci(4,"Ceyda","11A")
    val ogrenci5 = Ogrenci(5,"Zeynep","12C")
    val ogrenciler = ArrayList<Ogrenci>()

    ogrenciler.add(ogrenci1)
    ogrenciler.add(ogrenci2)
    ogrenciler.add(ogrenci3)
    ogrenciler.add(ogrenci4)
    ogrenciler.add(ogrenci5)

    for (o in ogrenciler){
        println("************************")

        println("Ögrenci No    : ${o.no}")
        println("Ögrenci Ad    : ${o.ad}")
        println("Ögrenci Sınıf : ${o.sinif}")
    }
    // ad içeriğine göre
    val filterName = ogrenciler.filter { (it.ad.toLowerCase()).contains("a") } /// lowercase olmadan ahmet gelmez.
    for (o in filterName){
        println("************************")
        println("Ögrenci No    : ${o.no}")
        println("Ögrenci Ad    : ${o.ad}")
        println("Ögrenci Sınıf : ${o.sinif}")

    }
    val filterNo = ogrenciler.filter { it.no >= 2 } // nosu 2 ve 2 den büyük olanlar
    for (o in filterNo){
        println("************************")
        println("Ögrenci No    : ${o.no}")
        println("Ögrenci Ad    : ${o.ad}")
        println("Ögrenci Sınıf : ${o.sinif}")

    }
    println("11. sınıflar")
    val filterClass = ogrenciler.filter { (it.sinif).contains("11") } // 11. sınıfları getirir
    for (o in filterClass){
        println("************************")
        println("Ögrenci No    : ${o.no}")
        println("Ögrenci Ad    : ${o.ad}")
        println("Ögrenci Sınıf : ${o.sinif}")

    }


}