package com.rao.com.idealarchitecture.data.remote

import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.data.respository.PostsDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRemoteDataSource @Inject constructor(
    private val postsService: PostsService
): PostsDataSource {
    override fun refreshPosts() {

    }

    override fun getAllPosts(size : Long): Flowable<List<PostEntity>> {
        return postsService.getPosts()
            .flatMap { posts ->
                Flowable.fromIterable(posts)
                    .take(size)
                    .toList().toFlowable()
            }
    }

    override fun saveAllPosts(posts: List<PostEntity>) {
        //Do nothing here as we donot need to save in remote
    }
}