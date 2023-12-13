package com.hakanbaysal20.collections.composition

import java.util.Scanner

fun main() {

    val girdi = Scanner(System.`in`)
    val personeller = ArrayList<Personel>()


    for (i in 1..5){
        println("$i. Personal Ad:")
        val isim = girdi.next()
        println("$i. Personel adres il : ")
        val il = girdi.next()
        println("$i. Personel adres ilçe : ")
        val ilce = girdi.next()
        val adres = Adres(il,ilce)
        val personel = Personel(i,isim,adres)
        personeller.add(personel)
    }
    for (p in personeller){
        println("*****************")
        println("Personel no : ${p.no}")
        println("Personel ad : ${p.isim}")
        println("Personel adres : ${p.adres.il} / ${p.adres.ilce}")
    }
}