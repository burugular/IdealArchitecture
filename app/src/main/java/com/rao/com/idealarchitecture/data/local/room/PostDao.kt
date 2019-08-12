package com.rao.com.idealarchitecture.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Maybe

@Dao
interface PostDao {
    @Query("SELECT * FROM Posts")
    fun getAllPosts(): Maybe<List<PostEntity>>

    @Insert
    fun insertAllPosts(vararg users: PostEntity)
}