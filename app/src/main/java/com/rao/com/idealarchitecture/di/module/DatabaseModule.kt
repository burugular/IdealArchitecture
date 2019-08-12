package com.rao.com.idealarchitecture.di.module

import android.arch.persistence.room.Room
import com.rao.com.idealarchitecture.IAApplication
import com.rao.com.idealarchitecture.data.local.room.AppDatabase
import com.rao.com.idealarchitecture.data.local.room.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: IAApplication): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "bl.db").build()
    }

    @Singleton
    @Provides
    fun providePostsDao(database: AppDatabase): PostDao = database.postdao()
}