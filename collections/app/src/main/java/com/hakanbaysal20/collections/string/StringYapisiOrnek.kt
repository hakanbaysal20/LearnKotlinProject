package com.hakanbaysal20.collections.string

fun main() {

    val str1 = "Merhaba"
    println(str1)

    var str2 = String()
    str2 = "Kotlin"
    println(str2)

    println(str2)

    var str3 = """
        Nasılsın
        Merhaba
        Hey
        
    """.trimIndent() // trimIndent boşlukları kaldırmak için eklenen metod
    println(str3)
    val str4 = ""
    var str5 = String()
    str5 = "Hakan"
    if (str4.isEmpty()){
        println("str 4 boş")
    }else{
        println("str 4 dolu")
    }
    if (str5.isEmpty()){
        println("str 5 boş")
    }else{
        println("str 5 dolu")
    }
    val varA = 10
    val varB = 20
    println("$varA x $varB = ${varA * varB}")
    val str6 = "Merhaba"
    val str7 = " Dünya"
    println(str6 + str7)
    val str8 = "Merhaba,Kotlin !"
    println("$str8 boyutu : ${str8.length}")

    val str9 = "Merhaba"
    val str10 = "Merhaba Dünya"
    if (str9 == str10){
        println("$str9 ve $str10 eşittir")
    }else{
        println("$str9 ve $str10 eşit değildir")
    }
    val str11 = "Merhaba"
    for (s in str11){
        println(s)
    }
}