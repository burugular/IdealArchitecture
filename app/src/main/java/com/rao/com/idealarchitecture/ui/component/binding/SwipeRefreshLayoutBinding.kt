package com.rao.com.idealarchitecture.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout

object SwipeRefreshLayoutBinding {
    @BindingAdapter("app:isRefreshing")
    @JvmStatic
    fun SwipeRefreshLayout.isRefreshing(isRefreshing: Boolean) {
        this.isRefreshing = isRefreshing
    }

    @BindingAdapter("app:onRefreshListener")
    @JvmStatic
    fun SwipeRefreshLayout.setOnRefreshListener(func: () -> Unit) {
        setOnRefreshListener { func() }
    }
}