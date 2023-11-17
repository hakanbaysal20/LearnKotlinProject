package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main(){
    print("Toplama (1)\nÇıkarma (2)\nÇarpma (3)\nBölme (4)\n Seçiminiz :")
    val girdi = Scanner(System.`in`)
    val secim = girdi.nextInt()
    print("Birinci sayıyı gir: ")
    val a = girdi.nextInt()
    print("İkinci sayıyı gir: ")
    val  b = girdi.nextInt()


    if (secim == 1){
        println("Toplama : ${a + b}")
    }else if (secim == 2){
        println("Çıkarma : ${a - b}")

    }else if (secim == 3){
        println("Çarpma : ${a * b}")
    }else if (secim == 4){
        println("Bölme : ${a / b}")
    }else{
        println("Yanlış tuşlama yaptınız")
    }

}