package com.hakanbaysal20.contactsappmvvm.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.push(it:View,id:Int) {
    findNavController(it).navigate(id)
}
fun Navigation.push(it:View,navDirections:NavDirections) {
    findNavController(it).navigate(navDirections)
}