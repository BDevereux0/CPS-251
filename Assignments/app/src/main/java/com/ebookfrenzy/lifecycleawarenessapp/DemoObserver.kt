@file:Suppress("DEPRECATION")

package com.ebookfrenzy.lifecycleawarenessapp


import androidx.lifecycle.Lifecycle

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.ebookfrenzy.lifecycleawarenessapp.ui.main.MainViewModel


class DemoObserver:LifecycleObserver {
    private var mvm = MainViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event){
        mvm.setText(owner.lifecycle.currentState.name)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        mvm.setText("PAUSED")
    }


}