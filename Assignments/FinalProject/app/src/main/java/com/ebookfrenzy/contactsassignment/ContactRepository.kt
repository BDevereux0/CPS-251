package com.ebookfrenzy.contactsassignment

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
                ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact){
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private fun asyncInsert(contact: Contact){
        contactDao?.insertContact(contact)
    }


    fun findContact(name: String){
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

    fun deleteContact(name: String){
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }

    private fun asyncDelete(name: String){
        contactDao?.deleteContact(name)
    }

     fun sortASC(){
        coroutineScope.async(Dispatchers.Main) {
            searchResults.value = asyncSortASC().await()
        }
    }

    private fun asyncSortASC() : Deferred<List<Contact>?> =
        coroutineScope.async (Dispatchers.IO){
            return@async contactDao?.getASC()
        }

    fun sortDESC(){
        coroutineScope.async(Dispatchers.Main) {
            searchResults.value = asyncSortDESC().await()
        }
    }

    private fun asyncSortDESC() : Deferred<List<Contact>?> =
        coroutineScope.async (Dispatchers.IO){
            return@async contactDao?.getDESC()
        }
}