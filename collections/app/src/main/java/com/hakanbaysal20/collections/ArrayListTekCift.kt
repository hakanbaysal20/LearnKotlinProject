package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val sayilar = ArrayList<Int>()
    val cift = ArrayList<Int>()
    val tek = ArrayList<Int>()
    sayilar.add(11)
    sayilar.add(22)
    sayilar.add(33)
    sayilar.add(44)
    sayilar.add(55)
    for (i in sayilar){
        val sonuc = i % 2
        if (sonuc == 0){
            cift.add(i)
        }else {
            tek.add(i)
        }
    }
    println("Tek")
    for (i in tek){
        println(i)
    }
    println("Çift")
    for (i in cift){
        println(i)
    }
}