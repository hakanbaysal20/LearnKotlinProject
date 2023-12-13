package com.hakanbaysal20.collections

import java.util.Scanner

fun main() {

    val kayitliOgrenci = ArrayList<Ogrenci>()

    val girdi = Scanner(System.`in`)


    var no = 0
    while (true){
        println("Öğrenci adı gir")
        val isim = girdi.next()
        println("Öğrenci sınıfını gir")
        val sinif = girdi.next()
        no += 1
        val ogrenci = Ogrenci(no,isim,sinif)

        kayitliOgrenci.add(ogrenci)
        println("Çıkmak için (1) - Devam etmek için diğer sayılar")
        val cikis = girdi.nextInt()
        if (cikis == 1){

            for (i in kayitliOgrenci){
                println(i.no)
                println(i.ad)
                println(i.sinif)

            }
            println("Çıkış yapıldı")

            break
        }
    }


}