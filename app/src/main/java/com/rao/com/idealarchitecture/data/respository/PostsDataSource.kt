package com.rao.com.idealarchitecture.data.respository

import com.rao.com.idealarchitecture.data.local.room.PostEntity
import io.reactivex.Flowable

interface PostsDataSource {

    fun getAllPosts(size : Long): Flowable<List<PostEntity>>

    fun saveAllPosts(posts: List<PostEntity>)

    fun refreshPosts()
}