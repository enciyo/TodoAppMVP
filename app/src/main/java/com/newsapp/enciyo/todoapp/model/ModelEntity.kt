package com.newsapp.enciyo.todoapp.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.Nullable


@Entity(tableName = "taskmodel")
data class ModelEntity(

    @Nullable
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "detail")
    var detail: String,

    @ColumnInfo(name = "tag")
    var tag:String


)