package com.rao.com.idealarchitecture.ui.component.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.ui.component.adapter.PostsAdapter

object RecyclerViewBinding {
    @BindingAdapter("app:addVerticalItemDecoration")
    @JvmStatic
    fun RecyclerView.addVerticalItemDecoration(isVertical: Boolean) {
        addItemDecoration(DividerItemDecoration(context, if (isVertical) DividerItemDecoration.VERTICAL else DividerItemDecoration.HORIZONTAL))
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun setListPosts(recyclerView: RecyclerView, items: List<PostEntity>) {
        with(recyclerView.adapter as PostsAdapter?) {
            this?.setData(items)
        }
    }
}