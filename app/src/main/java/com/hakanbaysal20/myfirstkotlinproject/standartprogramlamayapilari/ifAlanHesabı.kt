package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main(){

    println("(1) Çember alanı için 1 tuşlayınız\n(2) Dikdörtgen alanı için 2 tuşlayınız\n")
    val girdi = Scanner(System.`in`) // girdiyi bir kez tanımladıktan sonra dilediğimiz kadar kullanabiliriz.
    val secim = girdi.nextInt()
    if (secim == 1){
        val pi = 3.14
        print("Yarıçap giriniz:")
        val yariCap = girdi.nextInt() // girdi 2. kez kullanıldı
        val sonuc =yariCap * yariCap * pi
        println("Çemberin alanı : $sonuc")


    }else if (secim == 2){
        print("Kısa kenarı giriniz :")
        val  kisaKenar = girdi.nextInt() // girdi 3. kez kullanıldı

        print("Uzun kenarı giriniz :")

        val uzunKenar = girdi.nextInt()
        var sonuc = kisaKenar * uzunKenar
        println("Dikdörtgenin alanı : $sonuc")

    }else{
        println("Yanlış tuşlama yaptınız")
    }

}