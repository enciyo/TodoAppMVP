package com.newsapp.enciyo.todoapp.model.detailDao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Maybe

@Dao
interface DetailDao {

    @Query("SELECT * FROM detail_table")
    fun getAllTask(): Maybe<List<DetailEntity>>

    @Query("SELECT * FROM detail_table where cardTitle LIKE  :name1 AND `cardDetail` LIKE :detail")
    fun findByName(name1: String, detail: String): DetailEntity

    @Insert
    fun insert(tasks: DetailEntity)

    @Delete
    fun delete(tasks: DetailEntity)

}

