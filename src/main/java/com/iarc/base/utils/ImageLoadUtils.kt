package com.iarc.base.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * author:kanlulu
 * data  :7/5/21 5:24 PM
 *
 * Glide 图片加载工具类
 **/
object ImageLoadUtils {
    private val placeHolderColor by lazy { ColorDrawable(Color.WHITE) }

    /**
     * @param context 请使用activity或fragment的context，不要使用application的context
     * @param url: 图片链接地址
     * @param targetView:需要加载的ImageView
     * @param width:图片需要加载的宽
     * @param height:图片需要加载的高
     */
    fun loadImage(
        context: Context,
        url: String,
        targetView: ImageView,
        width: Int,
        height: Int,
        onLoadFailed: ((e: GlideException?) -> Unit) = {},
        onResourceReady: ((resource: Drawable?) -> Unit) = {},
    ) {
        Glide.with(context)
            .load(url)
            .override(width, height)
            .placeholder(placeHolderColor)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    onLoadFailed.invoke(e)
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onResourceReady.invoke(resource)
                    return true
                }
            })
            .into(targetView)
    }

    fun loadCircleImage(
        context: Context,
        url: String,
        targetView: ImageView,
        width: Int,
        height: Int,
        onLoadFailed: ((e: GlideException?) -> Unit) = {},
        onResourceReady: ((resource: Drawable?) -> Unit) = {},
    ) {
        Glide.with(context)
            .load(url)
            .override(width, height)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    onLoadFailed.invoke(e)
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onResourceReady.invoke(resource)
                    return true
                }
            })
            .into(targetView)
    }

    /**
     * 带回调的
     */
    fun loadWithListener(
        context: Context,
        url: String,
        targetView: ImageView,
        width: Int,
        height: Int,
        onLoadFailed: ((e: GlideException?) -> Unit) = {},
        onResourceReady: ((resource: Drawable?) -> Unit) = {},
    ) {
        Glide.with(context)
            .load(url)
            .override(width, height)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    onLoadFailed.invoke(e)
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onResourceReady.invoke(resource)
                    return true
                }
            })
            .into(targetView)
    }

    fun loadGif(context: Context,) {

    }
}