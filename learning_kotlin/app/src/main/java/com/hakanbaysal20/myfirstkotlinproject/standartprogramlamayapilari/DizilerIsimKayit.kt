package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main() {
    val girdi = Scanner(System.`in`)
    var isimler = Array<String>(5){""}// 5 elemanlı boş bir dizi
    for (i in 0 until isimler.count()){
        println("${i+1}. ismi giriniz")
        val girilenIsim = girdi.next();
        isimler[i] = girilenIsim
    }
    for ((index, i) in isimler.withIndex()){
        println("$index : $i")
    }


}