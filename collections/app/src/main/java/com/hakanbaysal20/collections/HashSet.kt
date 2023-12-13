package com.hakanbaysal20.collections

import java.util.HashSet

fun main() {

    val sayilar = HashSet<Int>()
    sayilar.add(10)
    sayilar.add(20)
    sayilar.add(30)
    println(sayilar.toString())
    sayilar.add(21)
    println(sayilar.toString())
    println(sayilar.elementAt(1)) // 1. indeksteki sayi
    println(sayilar.size)
    println(sayilar.isEmpty()) // boş mu? bool
    println(sayilar.contains(20)) // sayılar içerisinde "20" verisi var mı?

    for (s in sayilar){
        println(s)
    }
    for ((index,s) in sayilar.withIndex()){
        println("Index : $index - Sayı : $s")
    }
    sayilar.remove(10) // 10 var ise siler
    println(sayilar.toString())
    sayilar.clear() // bütün elemanları siler
    println(sayilar.toString())



}