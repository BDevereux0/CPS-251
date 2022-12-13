package com.ebookfrenzy.contactsassignment.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.contactsassignment.Contact
import com.ebookfrenzy.contactsassignment.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(contact: Contact){
        repository.insertContact(contact)
    }

    fun deleteContact(name: String){
        repository.deleteContact(name)
    }

    fun findContact(name: String){
        repository.findContact(name)
    }

    fun sortASC(){
        repository.sortASC()
    }

    fun sortDESC(){
        repository.sortDESC()
    }

    fun getSearchResults(): MutableLiveData<List<Contact>>{
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>?{
        return allContacts
    }
}