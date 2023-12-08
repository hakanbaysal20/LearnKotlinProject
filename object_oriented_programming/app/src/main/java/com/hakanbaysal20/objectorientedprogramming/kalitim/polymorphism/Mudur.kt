package com.hakanbaysal20.objectorientedprogramming.kalitim.polymorphism

open class Mudur:Personel() {
    fun iseAl(p:Personel) {
        p.iseAlindi()
    }
    fun terfiEttir(m:Personel) {
      //  (m as Ogretmen).maasArtır()  /// m değişkeni Personeldi. personel sadece kendi metoduna erişiyordu,(superclass). downcasting yaparak(m'e as Ogretmen ile ogretmen olduğunu söyledik ve Ogretmen classının metoduna eriştik)

        if(m is Ogretmen){// tip kontrolü varsa downcastinge gerek yok
            m.maasArtır()
        }else{
            println("işciler terfi alamaz")
        }

    }
}