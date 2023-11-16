package com.hakanbaysal20.myfirstkotlinproject

fun main(){

    for(i in 3..5){ /// 3 ten 5 e yazar  sırasıyla 3,4,5
        println(i)
    }

    // 10 ile 20 arasında 5 er 5 er artsın
    for (i in 10..20 step 5){
        println(i)
    }
    //değişkenler ile yapalım
    var baslangic = 10
    var bitis = 20
    var artis = 5
    for (i in baslangic..bitis step artis){

        println("i : $i")
    }
    // 20 den 10 a 2şer
    for (a in 20 downTo 10 step 2){
        println("a : $a")
    }
    for (c in 1 until 5){
        println("1 den 5 e kadar: $c")
    }

    //while
    var sayac = 1
    while (sayac <= 4){
        println("sayac : $sayac")
        sayac ++
    }



}