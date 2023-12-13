package com.hakanbaysal20.collections

class Ogrenci(var no:Int,var ad:String,var sinif:String) {
    override fun hashCode(): Int {
        return this.no
    }

    override fun equals(other: Any?): Boolean {
        if (this.no == (other as Ogrenci).no){   /// no other no ile eşitse kayıt yapma eşit depilse kayıt yap
            return true
        }else{
            return  false
        }
    }
}