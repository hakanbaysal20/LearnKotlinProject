package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val k1 = Kisiler(1,"Ahmet")
    val k2 = Kisiler(2,"Zeyno")
    val k3 = Kisiler(3,"Burkay")
    val kisiler = ArrayList<Kisiler>()
    kisiler.add(k1)
    kisiler.add(k2)
    kisiler.add(k3)
    println("Önce")
    for (kisi in kisiler){
        println("Kisi no : ${kisi.kisiNo}")
        println("Kisi ad : ${kisi.kisiAd}")
    }
    println("Sayısal kucukten buyuge")
    val siralama = kisiler.sortedWith(compareBy { it.kisiNo})

    for (k in siralama){
        println("Kisi no : ${k.kisiNo}")
        println("Kisi ad : ${k.kisiAd}")
    }
    println("büyükten kucuge")
    val siralama2 = kisiler.sortedWith(compareByDescending { it.kisiNo })

    for (k in siralama2){
        println("Kisi no : ${k.kisiNo}")
        println("Kisi ad : ${k.kisiAd}")
    }

    println("Alfabetik sıralama(sondan başa)")
    val siralama3 = kisiler.sortedWith(compareByDescending { it.kisiAd })
    for (k in siralama3){
        println("Kisi no : ${k.kisiNo}")
        println("Kisi ad : ${k.kisiAd}")
    }

}