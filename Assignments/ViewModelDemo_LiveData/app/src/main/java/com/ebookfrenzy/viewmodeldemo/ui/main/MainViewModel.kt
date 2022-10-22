package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private val rate = 0.74f
    private var dollarText = ""
   // private var result: Float = 0f //this is removed to use MutableLive Data. See ch. 40 and 41 for more info.
    private var result: MutableLiveData<Float> = MutableLiveData()



    fun setAmount(value: String){
        this.dollarText = value
      //result = value.toFloat() * rate //removed for same reason in line 9. Also result now requires a MutableLiveData object
        result.value = value.toFloat() * rate
    }

    /*fun getResult(): Float { //rewriting this fun below to return a MutableLiveObject
        return result
    }*/

    fun getResult():MutableLiveData<Float>{
        return result
    }

}