package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {
    val sayilar = ArrayList<Int>()

    sayilar.add(10)
    sayilar.add(20)
    sayilar.add(30)
    sayilar.add(40)
    sayilar.add(50)
    sayilar.add(60)
    sayilar.add(70)
    sayilar.add(80)
    sayilar.add(90)
    sayilar.add(100)


    var toplam = 0
    for (i in sayilar){
        toplam = toplam + i
    }
    println("Ortalama ${toplam/sayilar.size}")
}