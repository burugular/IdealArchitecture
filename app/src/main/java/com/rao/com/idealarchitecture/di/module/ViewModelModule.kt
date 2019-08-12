package com.rao.com.idealarchitecture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.rao.com.idealarchitecture.di.ViewModelKey
import com.rao.com.idealarchitecture.ui.main.post.PostViewModel
import com.rao.com.idealarchitecture.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [AppModule::class, RepositoryModule::class])
abstract class ViewModelModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindHomeViewModel(viewModel: PostViewModel): ViewModel

}