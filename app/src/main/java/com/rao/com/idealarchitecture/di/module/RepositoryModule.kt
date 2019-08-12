package com.rao.com.idealarchitecture.di.module

import com.rao.com.idealarchitecture.data.local.PostsLocalDataSource
import com.rao.com.idealarchitecture.data.remote.PostsRemoteDataSource
import com.rao.com.idealarchitecture.data.respository.PostsDataSource
import com.rao.com.idealarchitecture.di.qualifier.LocalData
import com.rao.com.idealarchitecture.di.qualifier.RemoteData
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    @LocalData
    abstract fun bindPostsLocalDataSource(postsLocalDataSource: PostsLocalDataSource): PostsDataSource

    @Singleton
    @Binds
    @RemoteData
    abstract fun bindPostsRemoteDataSource(postsRemoteDataSource: PostsRemoteDataSource): PostsDataSource
}