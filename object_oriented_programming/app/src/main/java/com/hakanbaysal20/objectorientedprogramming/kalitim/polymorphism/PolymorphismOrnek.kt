package com.hakanbaysal20.objectorientedprogramming.kalitim.polymorphism

fun main() {
    val ogretmen:Personel = Ogretmen()
    val isci:Personel = Isci()
    val mudur = Mudur()
    val isci1 = Isci()
    isci1.istifaEt(isci1)
    mudur.iseAl(ogretmen) // Mudur classında ise al fonksiyonuna personel classından herhangi bir personel nesnesi al demiştik
    // isci ve ogretmeni personel türünde tanımladığımız için burada kullanabiliriz
    mudur.iseAl(isci)
    mudur.iseAl(ogretmen)
    mudur.terfiEttir(ogretmen)
    mudur.terfiEttir(isci) // terfi ettir Ogretmen bekler işci beklemez.
}