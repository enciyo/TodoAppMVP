package com.newsapp.enciyo.todoapp.model.detailDao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "detail_table")
data class DetailEntity (

    @NotNull
    @PrimaryKey(autoGenerate = true)
    var taskId: Int =0,

    @ColumnInfo(name = "cardTitle")
    var taskTitle:String,

    @ColumnInfo(name = "cardDetail")
    var taskDetail:String

)