package com.ebookfrenzy.lifecycleawarenessapp.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object{
        var list = ArrayList<String>()

        fun setText(value: String){
            list.add(value)
            if (value.contains("RESUMED")|| value.contains("PAUSED") ||
                value.contains("DESTROYED")){
                list.add("****")
            }
        }
    }

    fun getText(): ArrayList<String> {
        return list
    }
}