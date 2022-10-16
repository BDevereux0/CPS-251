package com.ebookfrenzy.addnamesavedata1.ui.main
//IMPORTANT: This class allows persistent data. It is not wiped when an activity/fragment is destroyed.
//How it works: Setter/Getter system. Fragment calls ViewModel.doSomething()
//Refer to ch. 40 for instructions on set up (i.e. binding, which methods are needed, etc..)
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameList =  ArrayList<String>()

    fun addName(name : String){  //fragment calls this method to pass data
        nameList.add(name)
    }

    fun getList():ArrayList<String>{
        return nameList
    }
}