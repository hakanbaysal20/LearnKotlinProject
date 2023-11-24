package com.hakanbaysal20.objectorientedprogramming.kalitim.polymorphism

open class Mudur:Personel() {
    fun iseAl(p:Personel) {
        p.iseAlindi()
    }
    fun terfiEttir(m:Ogretmen) {
        m.maasArtır()
    }
}