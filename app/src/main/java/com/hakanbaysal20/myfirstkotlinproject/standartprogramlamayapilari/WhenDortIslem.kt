package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main(){

    val girdi = Scanner(System.`in`)
    println("Toplama (1)\nÇıkarma(2)\nÇarpma(3)\nBölme(4)\n")
    val secim = girdi.nextInt()

    println("Birinci sayıyı gir: ")
    val sayi1 = girdi.nextInt()
    println("İkinci sayıyı gir: ")
    val sayi2 = girdi.nextInt()

    when(secim){

        1 -> println("Toplama: ${sayi1 + sayi2}")
        2 -> println("Çıkarma: ${sayi1 - sayi2}")
        3 -> println("Çarpma: ${sayi1 * sayi2}")
        4 -> println("Bölme: ${sayi1 / sayi2}")
        else -> println("Yanlış tuşlama yaptınız")
    }


}