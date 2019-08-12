package com.rao.com.idealarchitecture.data.remote

import com.rao.com.idealarchitecture.data.local.room.PostEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET

interface PostsService {

    @GET("/posts")
    fun getPosts(): Flowable<List<PostEntity>>
}