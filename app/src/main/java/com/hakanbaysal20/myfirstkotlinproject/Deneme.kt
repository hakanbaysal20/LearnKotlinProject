package com.hakanbaysal20.myfirstkotlinproject

class Deneme {
    var x = 10  // global değişken
    var y = 20  // global değişken
    fun topla(){
        var x = 40 // x lokalde tanımlandığı zaman lokaldeki x geçerli olur. lokal globalden baskındır.
        var z = x + y // lokal değişken
        println(z)
    }
}