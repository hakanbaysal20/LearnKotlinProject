package com.hakanbaysal20.objectorientedprogramming.interfacea.ornek

import java.util.ArrayList

fun main() {
    val aslan = Aslan()
    val amasyaElmasi:Elma = AmasyaElmasi()
    val elma = Elma()
    val tavuk:Eatable = Tavuk()
    val nesneler = arrayOf(aslan,amasyaElmasi,elma,tavuk)

    // amasya elmasına elma türünde olduğunu aktardık ve kendi sınıfında squeeze ozelliği yok. (override ile eatable fonksiyonunu aldık)
    // fakat squeeze olmamasına rağmen elma olduğunu aktardığımız için amasya elması da howToSquezee fonksiyonunu çalıştırdı!
    for (nesne in nesneler){
        if (nesne is Eatable){
            nesne.howToEat()
        }
        if (nesne is Sqeezable){
            nesne.howToSqeezable()
        }
    }
}