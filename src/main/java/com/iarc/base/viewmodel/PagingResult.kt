package com.iarc.base.viewmodel

/**
 * author:kanlulu
 * data  :6/5/21 9:53 AM
 **/
data class PagingResult(
    val isSuccess: Boolean,//请求成功？
    val hasNext: Boolean,//是否有下一页？
    val isFirstPage: Boolean//是否是第一页？
)
