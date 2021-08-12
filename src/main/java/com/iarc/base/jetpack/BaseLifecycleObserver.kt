package com.iarc.base.jetpack

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author:kanlulu
 * data  :6/30/21 10:42 PM
 **/
open class BaseLifecycleObserver() : LifecycleObserver {
    //可以通过 lifecycle.currentState 查找页面状态
    var lifecycle: Lifecycle? = null

    constructor(lifecycle: Lifecycle) : this() {
        this.lifecycle = lifecycle
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onBaseCreate(){
        onCreate()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onBaseStart(){
        onStart()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onBaseResume(){
        onResume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onBasePause(){
        onPause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onBaseStop(){
        onStop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onBaseDestroy(){
        onDestroy()
    }

    open fun onCreate(){}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}
}