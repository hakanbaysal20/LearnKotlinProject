package com.hakanbaysal20.myfirstkotlinproject

fun main() {

    var ogrencininAdi : String = "Hakan" // static değildir val ise statictir.
    var ogrencininYasi : Int = 34
    var ogrencininBoyu : Double = 1.80
    var ogrencininBoyuFloat : Float = 1.80f

    var ogrenciBasHarfi : Char =  'H'

    println(ogrencininAdi)
    println(ogrencininYasi)
    println(ogrencininBoyu)
    println(ogrenciBasHarfi)


    var urunId = 3416
    var urunAdi = "Kol Saati"
    var urunAdet = 100
    var urunFiyat = 149.99
    var urunTedarikci = "rolex"

    println("Ürün id        : $urunId")
    println("Ürün adı       : $urunAdi")
    println("Ürün adet      : $urunAdet")
    println("Ürün fiyat     : $urunFiyat")
    println("Ürün tedarikçi : $urunTedarikci")

    println("$urunTedarikci marka $urunAdi $urunFiyat fiyatla satılmaktadır. Stokta $urunAdet adet kalmıştır.")
    var a = 10
    var b = 20
    println("$a ve $b nin toplamı : ${a + b}")




}