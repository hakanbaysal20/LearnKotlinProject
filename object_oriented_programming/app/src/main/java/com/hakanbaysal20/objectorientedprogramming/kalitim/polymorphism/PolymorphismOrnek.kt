package com.hakanbaysal20.objectorientedprogramming.kalitim.polymorphism

fun main() {
    val ogretmen:Personel = Ogretmen()
    val isci:Personel = Isci()
    val mudur = Mudur()
    mudur.iseAl(ogretmen) // Mudur classında ise al fonksiyonuna personel classından herhangi bir personel nesnesi al demiştik
    // isci ve ogretmeni personel türünde tanımladığımız için burada kullanabiliriz
    mudur.iseAl(isci)
}