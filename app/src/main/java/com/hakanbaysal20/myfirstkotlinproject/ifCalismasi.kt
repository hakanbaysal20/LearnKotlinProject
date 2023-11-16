package com.hakanbaysal20.myfirstkotlinproject


fun main(){
    var yas = 18
    var isim = "Mehmet"

    //ornek 1
    if (yas >= 18){
        println("Reşitsiniz")
    }else{
        println("Reşit değilsiniz")
    }

    //ornek 2
    if (isim == "Ahmet"){
        println("Merhaba Ahmet")
    }else if (isim == "Mehmet"){
        println("Merhaba Mehmet")
    }else{
        println("Tanınmayan kişi")
    }
    // coklu sart and
    var kullaniciAdi = "admin"
    var sifre = 12345
    if (sifre == 12345 && kullaniciAdi == "admin"){
        println("Hoşgeldiniz")
    }else{
        println("Hatalı giriş")
    }

    // coklu sart or
    var sinif = 9
    if (sinif == 9 || sinif == 10 || sinif == 11 || sinif == 12){
        println("Ayt sınavına hazırlanabilirsiniz")
    }else if (sinif == 8){
        println("En az 1 kişi daha gerek")
    }else{
        println("Hazır değilsiniz")
    }
    // kısaltma
    var a = 11
    var b = 10

    if (a == b) println("eşit") else println("eşit değil")
}