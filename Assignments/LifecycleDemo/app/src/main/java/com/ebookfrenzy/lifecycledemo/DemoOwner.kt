package com.ebookfrenzy.lifecycledemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

//class DemoOwner: LifecycleOwner {
    /*private val printMsg = "printMsg"

    private val lifecycleRegistry: LifecycleRegistry

    init {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycle.addObserver(DemoObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun startOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        print("HelloStart")
    }

    fun stopOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        print("HelloStop")
    }

    fun resumeOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        print("HelloResume")
    }

    fun destroyOwner(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        Log.d(printMsg,"HelloDestroy123")
        }*/
    //}
