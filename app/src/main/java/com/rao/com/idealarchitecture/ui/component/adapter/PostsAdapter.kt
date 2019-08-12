package com.rao.com.idealarchitecture.ui.component.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rao.com.idealarchitecture.R
import com.rao.com.idealarchitecture.data.local.room.PostEntity
import com.rao.com.idealarchitecture.databinding.ItemPostsBinding
import com.rao.com.idealarchitecture.ui.main.post.PostViewModel

class PostsAdapter(
    private var posts: List<PostEntity>,
    private val postViewModel: PostViewModel?
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.PostsViewHolder {
        val binding = DataBindingUtil.inflate<ItemPostsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_posts, parent, false
        )

        return PostsViewHolder(binding)
    }

    override fun getItemCount()= posts.size

    override fun onBindViewHolder(holder: PostsAdapter.PostsViewHolder, position: Int) =
        holder.bind(posts[position], object : PostsListener {
            override fun onPostsSelected(posts: PostEntity) {
                postViewModel?.openPosts(posts)
            }
        })


    class PostsViewHolder (private val binding: ItemPostsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(postsEntity: PostEntity, postsListener: PostsListener){
            with(binding)
            {
                posts = postsEntity
                listener = postsListener
                executePendingBindings()
            }
        }
    }

    fun setData( posts: List<PostEntity>) {
        this.posts = posts
        notifyDataSetChanged()
    }

}

interface PostsListener {
    fun onPostsSelected(posts: PostEntity)
}