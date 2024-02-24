package com.hakanbaysal20.contactsappmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.data.repository.ContactsDaoRepository

class HomeViewModel: ViewModel() {
    val cRepo = ContactsDaoRepository()
    var personsList = MutableLiveData<List<Person>>()
    init {
        getContacts()
        personsList = cRepo.getContactsVM()
    }
    fun searchPerson(word:String) {
        cRepo.searchPerson(word)
    }
    fun deletePerson(personId:Int) {
        cRepo.deletePerson(personId)
    }
    fun getContacts() {
        cRepo.getContacts()
    }
}