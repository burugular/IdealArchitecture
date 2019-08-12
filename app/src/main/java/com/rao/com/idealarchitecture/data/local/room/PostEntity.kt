package com.rao.com.idealarchitecture.data.local.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rao.com.idealarchitecture.util.RoomConverter


@Entity(tableName = "Posts")
@TypeConverters(RoomConverter::class)
data class PostEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    @Expose
    var userId: Int = 0,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String = "",

    @ColumnInfo(name = "body")
    @SerializedName("body")
    @Expose
    var body: String = ""
)