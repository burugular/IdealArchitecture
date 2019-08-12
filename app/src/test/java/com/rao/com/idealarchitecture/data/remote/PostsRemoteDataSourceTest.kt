package com.rao.com.idealarchitecture.data.remote

import com.rao.com.idealarchitecture.data.local.room.PostEntity
import io.reactivex.Flowable
import io.reactivex.subscribers.TestSubscriber
import org.hamcrest.CoreMatchers
import org.junit.Test

import org.junit.Assert.*
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Spy
import org.mockito.stubbing.OngoingStubbing
import java.lang.Exception


class PostsRemoteDataSourceTest {

    @Test
    fun shouldGetPostResource() {
        val postService = mock(PostsService::class.java)
        val postsRemoteDataSource = PostsRemoteDataSource(postService)
        Mockito.`when`(postService.getPosts()).thenReturn(buildPostModel())

        val flowablePost = postsRemoteDataSource.getAllPosts(10).test()

        assertEquals(10, flowablePost.values().get(0).size)
    }

    private fun buildPostModel(): Flowable<List<PostEntity>> {
        var mList = listOf<PostEntity>(
            PostEntity(1, 1, "Title 1", "Body 1"),
            PostEntity(2, 1, "Title 2", "Body 1"),
            PostEntity(3, 1, "Title 3", "Body 1"),
            PostEntity(4, 1, "Title 4", "Body 1"),
            PostEntity(5, 1, "Title 5", "Body 1"),
            PostEntity(6, 1, "Title 6", "Body 1"),
            PostEntity(7, 1, "Title 7", "Body 1"),
            PostEntity(8, 1, "Title 8", "Body 1"),
            PostEntity(9, 1, "Title 9", "Body 1"),
            PostEntity(10, 1, "Title 10", "Body 1"),
            PostEntity(11, 1, "Title 11", "Body 1"),
            PostEntity(12, 1, "Title 12", "Body 1"),
            PostEntity(13, 1, "Title 13", "Body 1")
        )
        return Flowable.fromArray(mList)
    }
}