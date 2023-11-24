package com.hakanbaysal20.objectorientedprogramming.kalitim

fun main() {
    val araba = Araba(renk = "Sephia", vites = "Manuel", kasaTipi = "Sedan");
    // nissan subclasstır. alt sınıftır. üst sınıfın özelliklerine erişir.
    // araç nissan için superclass araç için subclasstır.
    println(araba.renk)
    println(araba.vites)
    println(araba.kasaTipi)

    val nissan = Nissan(renk = "Beyaz", vites = "Manuel", kasaTipi = "Sedan", model = "micra")
    println(nissan.model) // model kendi özelliği
    println(nissan.renk) // renk araç sınıfından miras
    println(nissan.kasaTipi) // kasatipi araba sınıfından miras

    val saray = Saray(pencereSayisi = 30, kuleSayisi = 5)
    println(saray.pencereSayisi)
    println(saray.kuleSayisi)
    val villa = Villa(pencereSayisi = 10, garajVarMi = true)
    println(villa.pencereSayisi)
    println(villa.garajVarMi)

    val hayvan = Hayvan()
    hayvan.sesCikar()
    val memeli = Memeli()
    memeli.sesCikar()
    val kedi = Kedi()
    kedi.sesCikar()
    val kopek = Kopek()
    kopek.sesCikar()

}