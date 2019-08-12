package com.rao.com.idealarchitecture.ui.main.post

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rao.com.idealarchitecture.databinding.FragmentPostBinding
import com.rao.com.idealarchitecture.ui.component.adapter.PostsAdapter
import com.rao.com.idealarchitecture.ui.main.base.BaseFragment
import javax.inject.Inject

class PostFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var postViewModel: PostViewModel

    private lateinit var dataBinding: FragmentPostBinding

    private lateinit var postsAdapter: PostsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        postViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostViewModel::class.java)
        postsAdapter = PostsAdapter(ArrayList(0), postViewModel)

        dataBinding = FragmentPostBinding.inflate(inflater, container, false)
            .apply {
                this.viewModel = postViewModel
                this.adapter = postsAdapter
            }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postViewModel.start()
        handleUIEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        postViewModel.stop()
    }

    private fun handleUIEvent() {
        postViewModel.onPostsOpenEvent.observe(this,
            Observer { posts ->
                posts?.let{

                }
            })
    }
}