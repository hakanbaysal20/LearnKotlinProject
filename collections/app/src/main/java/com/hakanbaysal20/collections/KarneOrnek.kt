package com.hakanbaysal20.collections

import java.util.ArrayList
import java.util.Scanner

fun main() {

    val girdi = Scanner(System.`in`)
    val karne = ArrayList<Karne>()

    var toplam = 0

    while (true){
        println("Ders adını giriniz")
        val ad = girdi.next()
        println("Notu giriniz")
        val not = girdi.nextInt()
        toplam = toplam + not
        val ders = Karne(ad,not)
        karne.add(ders)
        println("Çıkmak için (1) - Devam etmek için herhangi bir sayı")
        val cikis = girdi.nextInt()
        if (cikis == 1){
            for (i in karne){
                println("${i.ad}: ${i.not}")
            }
            val ortalama = toplam / karne.size
            println("Ortalama : $ortalama")
            if (ortalama >= 50){
                println("Geçtiniz")
            }else{
                println("Kaldınız")
            }
            println("Çıkış yapıldı")
            break
        }else{
            continue
        }
    }


}