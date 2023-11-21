package com.hakanbaysal20.objectorientedprogramming

fun main() {
    var str1:String? = null
    str1?.trim() // 1 sorun varsa çalıştırmayacak
    str1!!.trim() // null olmadığından eminsek kullanılır. şuan hata alınır


   //2.yöntem
    if (str1 != null){
        str1.trim()
    }

}