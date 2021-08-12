package com.iarc.base.ext

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iarc.base.utils.MainLooper
import kotlin.math.abs

// 最近一次点击的时间
private var mLastClickTime: Long = 0

// 最近一次点击的控件ID
private var mLastClickViewId = 0

/**
 * @param interval 延时
 * @param withOthers 与其他控件同时判断快速点击，false计算自身控件的延时，true计算全部控件的延时
 * @param action 动作
 */
fun View.clickNoRepeat(
    interval: Long = 500,
    withOthers: Boolean = false,
    action: (view: View) -> Unit
) {
    setOnClickListener {
        if (!isFastDoubleClick(it, interval, withOthers)) {
            action(it)
        }
    }
}

/**
 * View的显示和隐藏
 */
fun View.showVisible(show: Boolean) {
    val status = if (show) View.VISIBLE else View.GONE
    if (visibility != status) {
        visibility = status
    }
}

fun Context.showToast(msg: String?) {
    MainLooper.instance.post {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

/**
 * 判断双击时间与 id
 * @param v 控件
 * @param intervalMillis 延时
 * @param withOthers 与其他控件同时判断快速点击
 */
private fun isFastDoubleClick(v: View, intervalMillis: Long, withOthers: Boolean = false): Boolean {
    val viewId = v.id
    val time = System.currentTimeMillis()
    val timeInterval = abs(time - mLastClickTime)
    return if ((withOthers && timeInterval < intervalMillis)
        || (!withOthers && timeInterval < intervalMillis && viewId == mLastClickViewId)
    )
        true
    else {
        mLastClickTime = time
        mLastClickViewId = viewId
        false
    }
}

// 绑定普通的Recyclerview
fun RecyclerView.init(
    layoutManger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<*>,
    isScroll: Boolean = true
): RecyclerView {
    layoutManager = layoutManger
    setHasFixedSize(true)
    adapter = bindAdapter
    isNestedScrollingEnabled = isScroll
    return this
}
