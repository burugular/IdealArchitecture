package com.rao.com.idealarchitecture.data.respository

import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.di.qualifier.LocalData
import com.rao.com.idealarchitecture.di.qualifier.RemoteData
import dagger.Module
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepository @Inject constructor(
    @LocalData private val localDataSource: PostsDataSource,
    @RemoteData private val remoteDataSource: PostsDataSource
) : PostsDataSource {


    private var cachedPosts = listOf<PostEntity>()

    private var cachePostsIsDirty = false

    override fun getAllPosts(size : Long): Flowable<List<PostEntity>> {
        if(cachedPosts.isNotEmpty() && !cachePostsIsDirty){
            return Flowable.just(cachedPosts)
        }

        val  remotePosts = getAndSaveRemotePosts(size)

        return if(cachePostsIsDirty) remotePosts else{
            val localPosts = getAndCacheLocalPosts(size)
            Flowable.concat(localPosts, remotePosts)
        }
    }

    override fun saveAllPosts(posts: List<PostEntity>) {
        localDataSource.saveAllPosts(posts)
        //remoteDataSource.saveAllPosts(posts)
    }


    private fun getAndSaveRemotePosts(size : Long) : Flowable<List<PostEntity>>{
        return remoteDataSource.getAllPosts(size)
            .doOnNext{posts ->
                localDataSource.saveAllPosts(posts)
                cachedPosts = posts
            }.doOnComplete{
                cachePostsIsDirty = false
            }
    }

    private fun getAndCacheLocalPosts(size : Long): Flowable<List<PostEntity>> {
        return localDataSource.getAllPosts(size).doOnNext { posts -> cachedPosts = posts }
    }

    override fun refreshPosts() {
        cachePostsIsDirty =true
    }

}