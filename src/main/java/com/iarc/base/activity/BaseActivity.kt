package com.iarc.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * author:kanlulu
 * data  :6/5/21 2:09 PM
 **/
abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var mDataBinding: DB

    abstract fun getLayoutId(): Int

    abstract fun initUI()

    abstract fun initObserve()

    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initUI()
        initObserve()
        initData()
    }

    private fun initDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBinding.lifecycleOwner = this
    }

}