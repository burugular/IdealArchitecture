package com.rao.com.idealarchitecture.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.Toolbar
import android.view.View

object ToolbarBinding {
    @BindingAdapter("app:navigationOnClickListener")
    @JvmStatic
    fun Toolbar.setNavigationOnClickListener(onClickListener: View.OnClickListener) {
        setNavigationOnClickListener(onClickListener)
    }
}