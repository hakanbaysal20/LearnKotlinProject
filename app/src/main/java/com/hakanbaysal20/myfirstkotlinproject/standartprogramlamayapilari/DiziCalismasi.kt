package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

fun main() {
    // genelde diziler val tanımlanır.
    // ekleme yapılacaksa veya değişiklik içerecekse var kullanırız
    // sabit boyutlu bir yapıdır. Başta ne kadar boyutu olduğu bellidir
    // mutable yapıdadır. (hem üzerinde işlem yapılabilir hem de verileri okuyabiliriz)
    // Tanımlama
    val dizi1 = Array<Int>(5){0} // [0,0,0,0,0]
    val dizi2 = arrayOf(1,190,1)
    val dizi3 = arrayOf<Int>(1,3,4,5)
    val dizi4 = arrayOf<String>("Ahmet","Çilek")
    val dizi5 = arrayOf(3,8,"Elma","Bursa")

    val meyveler = arrayOf<String>("Çilek","Muz","Elma","Kivi","Kiraz")

    //Verilere erişim
    val str1 = meyveler[2] //elma // 1. yöntem
    println(str1)
    val str2 = meyveler.get(3) // 2. yöntem
    println(str2)
    println(meyveler.size) // dizinin boyutuna erişim
    // yeni eleman eklenemez ama değişiklik yapabiliriz
    meyveler[1] = "Yeni muz"
    println(meyveler.contentToString()) // dizi içeriğini yazdırır
    meyveler.set(2,"Yeni Elma")
    println(meyveler.contentToString())

    // Array işlemleri
    println(meyveler.isEmpty()) // boş mu
    println(meyveler.count()) // boyut
    println(meyveler.first()) // ilk elemanı verir
    println(meyveler.last()) // son elemanı verir
    println(meyveler.indexOf("Kivi")) // elemanın indexini verir
    println(meyveler.contains("Yeni muz")) // muz var mı yok mu kontrol eder
    println(meyveler.max()) // alfabetik sıralamada sonuncu elemanı verir(türkçe karakterler sona gelir)
    println(meyveler.min()) // alfabetik ilk elemanı verir
    println(meyveler.sort()) // alfabetik kucukten buyuğe sıralar
    println(meyveler.contentToString())
    println(meyveler.reverse()) // terse çevir demek
    println(meyveler.contentToString())


}