package com.rao.com.idealarchitecture.di.module

import android.app.Application
import android.content.Context
import com.rao.com.idealarchitecture.IAApplication
import com.rao.com.idealarchitecture.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: IAApplication): Context

    @Binds
    abstract fun bindApplication(application: IAApplication): Application
}