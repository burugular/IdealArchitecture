package com.rao.com.idealarchitecture.ui.main.post

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableList
import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.data.respository.PostsRepository
import com.rao.com.idealarchitecture.ui.main.base.BaseViewModel
import com.rao.com.idealarchitecture.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val postsRepository: PostsRepository
) : BaseViewModel() {

    val isRefreshing = ObservableBoolean(false)
    val items: ObservableList<PostEntity> = ObservableArrayList()
    val onPostsOpenEvent = SingleLiveEvent<PostEntity>()

    private var disposable: Disposable? = null


    override fun start() {
        getAllPosts(false)
    }

    override fun stop() {
        disposable?.let { if (!it.isDisposed) it.dispose() }
    }

    fun refreshPosts() {
        getAllPosts(true)
    }

    fun openPosts(posts: PostEntity) {
        onPostsOpenEvent.value = posts
    }

    private fun getAllPosts(isRefresh: Boolean) {
        if (isRefresh) postsRepository.refreshPosts()

        disposable = postsRepository.getAllPosts(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isRefreshing.set(true) }
            .doAfterTerminate { isRefreshing.set(false) }
            .subscribe({ posts ->
                with(items) {
                    clear()
                    addAll(posts)
                }
            }, { error ->
                error.printStackTrace()
            })
    }
}