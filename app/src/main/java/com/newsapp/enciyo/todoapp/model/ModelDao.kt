package com.newsapp.enciyo.todoapp.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Maybe

@Dao
interface ModelDao {

        @Query("SELECT * FROM taskmodel")
        fun getAllBook(): Maybe<List<ModelEntity>>

        @Query("SELECT * FROM taskmodel where title LIKE  :name AND `detail` LIKE :detail")
            fun findByName(name: String, detail: String): ModelEntity

        @Insert
        fun insert(book: ModelEntity)

        @Delete
        fun delete(book: ModelEntity)

}