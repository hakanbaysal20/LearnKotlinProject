package com.hakanbaysal20.collections.string

fun main() {

    val str1 = "Merhaba"
    println(str1.subSequence(0,3)) // 0. indeksten 2. indekse kadar yazdırır
// string dizi gibi davranır
    // M - 0 , e - 1 ...
    val str2 = "Merhaba"
    if (str2.contains("er")){ // "er" içeriyor mu? - TRUE
        println("İçeriyor")
    }
    val str3 = "Merhaba"
    println(str3.toUpperCase()) // harflerin hepsi büyür
    println(str3.toLowerCase())//harflerin hepsi küçülür
    val str4 = "Merhaba Nasılsın"
    val dizi = str4.split(" ") // boşluğa göre parçalar
    for (i in dizi){
        println(i)
        // Merhaba
        // Nasılsın
    }
    val str5 = " Merhaba "
    println(str5.trim()) // boşluğu kaldırır. trim ile kullanıcının yanlışlıkla boşluğa tıklaması sebebiyle kullanılır

}