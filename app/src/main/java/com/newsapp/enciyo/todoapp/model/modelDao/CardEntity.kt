package com.newsapp.enciyo.todoapp.model.modelDao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.Nullable


@Entity(tableName = "taskmodel")
data class CardEntity(

    @Nullable
    @PrimaryKey(autoGenerate = true)
    var cardId: Int = 0,

    @ColumnInfo(name = "cardTitle")
    var cardTitle: String,

    @ColumnInfo(name = "cardDetail")
    var cardDetail: String

)

