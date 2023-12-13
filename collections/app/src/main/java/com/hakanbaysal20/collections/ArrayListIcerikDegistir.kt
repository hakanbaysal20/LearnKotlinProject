package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val sayilar = ArrayList<Int>()

    sayilar.add(1)
    sayilar.add(2)
    sayilar.add(3)
    sayilar.add(4)
    sayilar.add(5) //  1,2,3,4,5  ->   /2,4,6,8,10

    for ((index,s) in sayilar.withIndex()){
        val sonuc = s * 2   // sayıyı 2 ile carptık
        sayilar[index] = sonuc // indeks ile listede değiştirdik

    }
    for (i in sayilar){
        println(i)
    }
}