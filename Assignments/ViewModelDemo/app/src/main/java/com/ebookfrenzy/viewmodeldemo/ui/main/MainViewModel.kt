package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private val rate = 0.74f
   // private var dollarText = "" //removed for Data Binding Tutorial per Ch. 43
   // private var result: Float = 0f //this is removed to use MutableLive Data. See ch. 40 and 41 for more info.
    var dollarValue: MutableLiveData<String> = MutableLiveData() //this one gets edited
    var result: MutableLiveData<Float> = MutableLiveData() //this displays result

    fun convertValue(){
        dollarValue.let {
            if (!it.value.equals("")){
                result.value = it.value?.toFloat()?.times(rate)
            }else {
                result.value = 0f
            }
        }
    }



    /*fun setAmount(value: String){
        this.dollarText = value
      //result = value.toFloat() * rate //removed for same reason in line 9. Also result now requires a MutableLiveData object
        result.value = value.toFloat() * rate
    }

    *//*fun getResult(): Float { //rewriting this fun below to return a MutableLiveObject
        return result
    }*//*

    fun getResult():MutableLiveData<Float>{
        return result
    }*/ //removed for Data Binding Tutorial per Ch. 43 (lines 15-27, Note the comments to the right of certain lines.

}