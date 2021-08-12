package com.iarc.base.viewmodel

import androidx.lifecycle.*

/**
 * author:kanlulu
 * data  :6/4/21 4:10 PM
 **/
open class BaseViewModel : ViewModel(), LifecycleObserver {
    val httpError = MutableLiveData<String>()

    companion object {
        //默认翻页开始的页码
        const val PAGE_START_INDEX = 0
    }

    var pageNo = PAGE_START_INDEX
    var pageSize = 5


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onBaseCreate() {
        onCreate()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onBaseStart() {
        onStart()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onBaseResume() {
        onResume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onBasePause() {
        onPause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onBaseStop() {
        onStop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onBaseDestroy() {
        onDestroy()
    }

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}

}