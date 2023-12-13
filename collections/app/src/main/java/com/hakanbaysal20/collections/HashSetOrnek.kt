package com.hakanbaysal20.collections

import java.util.HashSet

fun main() {

    val ogrenci = HashSet<Ogrenci>()
    val o1 = Ogrenci(1,"Ahmet","12A")
    val o2 = Ogrenci(2,"Hakan","12C")
    val o3 = Ogrenci(3,"Fatih","12D")
    val o4 = Ogrenci(4,"Ahmet","12B")
    val o5 = Ogrenci(3,"Fatih","12A")

    ogrenci.add(o1)
    ogrenci.add(o2)
    ogrenci.add(o3)
    ogrenci.add(o4)
    ogrenci.add(o5)
    for (i in ogrenci){
        println("***************")
        println("Öğrenci no    : ${i.no}")
        println("Öğrenci ad    : ${i.ad}")
        println("Öğrenci sınıf : ${i.sinif}")
    }

}