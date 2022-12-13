package com.ebookfrenzy.contactsassignment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :contactName || '%'")
    fun findContact(contactName: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactName = :contactName")
    fun deleteContact(contactName: String)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY contactName COLLATE NOCASE ASC")
    fun getASC(): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY contactName COLLATE NOCASE DESC")
    fun getDESC(): List<Contact>
}