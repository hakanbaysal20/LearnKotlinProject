package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main(){

   val girdi = Scanner(System.`in`)

    while (true){

        /*
        println("Sayi giriniz ---- Çıkmak için (0)")
        val sayi1 = girdi.nextInt()
        if (sayi1 != 0){
            val sonuc = sayi1 % 2
            if (sonuc == 0){
                println("Çift")
            }else{
                println("Tek")
            }
        }else{
            println("Çıkış yapıldı")
            break
        }*/
        println("Sayı gir:")
        val sayi = girdi.nextInt()
        val sonuc = sayi % 2 // 2 ye böldüğümüzde kalan sayıyı verir
        if (sonuc == 0){
            println("Çift")
        }else{
            println("Tek")
        }
        println("Çıkmak için (1) devam etmek için diğer sayılar")
        val cikis = girdi.nextInt()

        if (cikis == 1){
            println("Çıkış yapıldı")
            break
        }

    }

}
