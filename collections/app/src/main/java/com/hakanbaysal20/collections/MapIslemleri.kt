package com.hakanbaysal20.collections

fun main() {

    val sayilar = mapOf<Int,String>(1 to "Bir",2 to "İki")
    val oranlar = mutableMapOf<Double,String>(1.5 to "Oran1",3.4 to "Oran2")
    val iller = HashMap<Int,String>()

    iller.put(16,"Bursa")
    iller.put(34,"Istanbul")
    println(iller.toString())
    iller.put(16,"Yeni Bursa") // 16 keyine sahip değeri güncelledik
    println(iller.toString())
    println(iller.get(34)) // 34 keyine sahip ili getirir
    println(iller.size)
    println(iller.count())
    println(iller.isEmpty())
    println(iller.containsKey(16)) // keye göre içerik arar
    println(iller.containsValue("Istanbul")) // value ya göre içerik arar
    for ((key,deger) in iller){
        println("$key : $deger")
    }
    iller.remove(16)
    println(iller.toString())
    iller.clear()
    println(iller.toString())
}