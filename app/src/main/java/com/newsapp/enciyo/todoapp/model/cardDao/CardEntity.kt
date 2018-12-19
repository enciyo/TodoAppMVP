package com.newsapp.enciyo.todoapp.model.cardDao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "taskmodel")
data class CardEntity(

    @NotNull
    @PrimaryKey(autoGenerate = true)
    var cardId: Int = 0,

    @ColumnInfo(name = "cardTitle")
    var cardTitle: String,

    @ColumnInfo(name = "cardDetail")
    var cardDetail: String

)

