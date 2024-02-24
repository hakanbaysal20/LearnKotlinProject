package com.hakanbaysal20.contactsappmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hakanbaysal20.contactsappmvvm.data.repository.ContactsDaoRepository

class PersonDetailViewModel: ViewModel(){
    val cRepo = ContactsDaoRepository()
    fun updateButton(personId:Int,personName:String,personNo:String) {
        cRepo.updateButton(personId,personName,personNo)
    }
}