package com.ebookfrenzy.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var inputText: MutableLiveData<String> = MutableLiveData()
    var outputText: MutableLiveData<String> = MutableLiveData()
    private var nameList = ArrayList<String>()

    init {
        if (nameList.isEmpty()){
            outputText.value = "No names to display"
        }
    }

    fun addName(){

        inputText.let{
            nameList.add(it.value.toString())
            var fullString = ""
            for (x: String in nameList){
                 fullString = fullString + x + "\n"
                 outputText.value = fullString
            }
        }
        inputText.value = ""
    }
}