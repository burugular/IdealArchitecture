package com.rao.com.idealarchitecture.data.local.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postdao() :PostDao
}