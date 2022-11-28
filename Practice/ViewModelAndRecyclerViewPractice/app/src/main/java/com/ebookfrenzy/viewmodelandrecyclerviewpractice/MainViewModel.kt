package com.ebookfrenzy.viewmodelandrecyclerviewpractice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var Tag = "SearchForMe"
    lateinit var nameToLower: String
    var nameList = ArrayList<String>()

    var nameToLower1: MutableLiveData<String> = MutableLiveData()

    fun nameToLower(newName:String){
        Log.i(Tag, newName)
        //nameToLower = newName
        nameToLower1.value = newName
        nameList.add(newName)
    }

    fun getLowerName():ArrayList<String>{
        return nameList
    }

    fun getName():MutableLiveData<String>{
        return nameToLower1
    }
    fun amountOfNames():Int{
        return nameList.size
    }
}