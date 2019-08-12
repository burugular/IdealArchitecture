package com.rao.com.idealarchitecture.data.local

import com.rao.com.idealarchitecture.data.local.room.PostDao
import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.data.respository.PostsDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsLocalDataSource @Inject constructor(
    private  val postDao: PostDao
) : PostsDataSource {
    override fun refreshPosts() {

    }

    override fun getAllPosts(size : Long): Flowable<List<PostEntity>> {
        return postDao.getAllPosts().toFlowable()
    }

    override fun saveAllPosts(posts: List<PostEntity>) {
        posts.map { postDao.insertAllPosts(it) }
    }

}