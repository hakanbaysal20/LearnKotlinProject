package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {

    val meyveler = ArrayList<String>()
    meyveler.add("Muz")
    meyveler.add("Çilek")
    meyveler.add("Kiraz")
    meyveler.add("Elma")
    meyveler.add("Kivi")
    println(meyveler.isEmpty()) // false
    println(meyveler.isNotEmpty()) // true
    println(meyveler.count()) // boyut verir
    println(meyveler.size) // boyut verir
    println(meyveler.first()) // ilk indeks itemını verir
    println(meyveler.last()) // son eleman gelir
    println(meyveler.contains("Kiraz")) // içeride kiraz var mı kontrol eder
    println(meyveler.contains("Kira"))
    println(meyveler.max()) // harf sıralamasına göre sonuncu elemanı verir
    println(meyveler.min()) // harf sıralamasına göre ilk elemanı verir
    meyveler.sort()  // sıralamaya sokar
    println(meyveler.toString())

    println(meyveler.reverse()) // arayList terse döner.
    println(meyveler.toString())
    meyveler.removeAt(3)  // 3. indeksteki item silinir
    println(meyveler.toString())
    meyveler.remove("Kivi") // kivi var ise onu siler
    println(meyveler.toString())
    meyveler.clear() // listeyi temizler
    println(meyveler.toString())

}