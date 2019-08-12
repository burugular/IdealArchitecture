package com.rao.com.idealarchitecture.di.module

import com.rao.com.idealarchitecture.ui.main.post.MainActivity
import com.rao.com.idealarchitecture.di.ActivityScoped
import com.rao.com.idealarchitecture.ui.main.post.PostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun bindMainActivity(): MainActivity

}