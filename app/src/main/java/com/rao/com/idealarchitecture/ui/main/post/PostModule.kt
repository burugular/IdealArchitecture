package com.rao.com.idealarchitecture.ui.main.post

import com.rao.com.idealarchitecture.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): PostFragment
}