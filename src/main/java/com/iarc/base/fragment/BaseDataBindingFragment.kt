package com.iarc.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * author:kanlulu
 * data  :7/5/21 6:15 PM
 **/
abstract class BaseDataBindingFragment<DB : ViewDataBinding> : Fragment() {
    lateinit var mDataBinding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return mDataBinding.root
    }

    abstract fun layoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserve()
        initData()
    }

    abstract fun initData()

    abstract fun initObserve()

    abstract fun initView()

    override fun onDestroyView() {
        super.onDestroyView()
        mDataBinding.unbind()
    }

}