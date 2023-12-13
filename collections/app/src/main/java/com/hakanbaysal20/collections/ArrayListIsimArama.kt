package com.hakanbaysal20.collections

import java.util.Scanner

fun main() {

    val isimler = ArrayList<String>()
    isimler.add("Ahmet")
    isimler.add("Mehmet")
    isimler.add("Ayşe")
    isimler.add("Döndü")
    isimler.add("Nuray")
    isimler.add("Hakan")
    val girdi = Scanner(System.`in`)
    val isim = girdi.next()
    for (i in isimler){
        if (i == isim){
            println("İsim mevcut")
            break
        }
    }

}