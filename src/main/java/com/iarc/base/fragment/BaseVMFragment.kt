package com.iarc.base.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iarc.base.utils.LogUtils
import com.iarc.base.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * author:kanlulu
 * data  :7/5/21 6:35 PM
 **/
abstract class BaseVMFragment<VM : BaseViewModel> : Fragment() {
    lateinit var mViewModel: VM

    abstract fun layoutId(): Int

    /**
     * fragment跳转Activity接收result
     */
    val startActivityLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            onActivityResultFromFragment(result)
        }

    private fun onActivityResultFromFragment(result: ActivityResult) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        initView()
        initListener()
    }

    abstract fun initListener()

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
    }

    abstract fun initView()
}