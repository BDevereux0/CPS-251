package com.ebookfrenzy.coroutineassignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData()
    var output: MutableLiveData<String> = MutableLiveData()

    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)

    fun outputStringBuilder(){
        name.let {
            Data.preventDuplication = true
            val random = (0..10).random()
            myCoroutineScope.launch(Dispatchers.Main) {
                performTask(random)
            }
        }
    }

    private suspend fun performTask(random: Int){
        delay(random.toLong())
        val outputNum = random * 1000
        output.value = "The name is ${name.value.toString()} and the delay was $outputNum milliseconds"
    }


}