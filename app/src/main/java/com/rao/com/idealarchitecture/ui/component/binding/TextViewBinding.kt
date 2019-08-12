package com.rao.com.idealarchitecture.ui.component.binding

import android.databinding.BindingAdapter
import android.text.Html
import android.widget.TextView

object TextViewBinding {
    @BindingAdapter("app:textHtml")
    @JvmStatic
    fun TextView.textHtml(text: String?) {
        text?.let { setText(Html.fromHtml(it)) }
    }
}