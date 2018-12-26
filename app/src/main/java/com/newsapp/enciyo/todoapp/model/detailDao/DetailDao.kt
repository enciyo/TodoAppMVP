package com.newsapp.enciyo.todoapp.model.detailDao

import android.arch.persistence.room.*
import io.reactivex.Maybe

@Dao
interface DetailDao {

    @Query("SELECT * FROM detail_table ORDER BY `taskState`")
    fun getAllTask(): Maybe<List<DetailEntity>>

    @Query("SELECT * FROM detail_table where `references` LIKE  :value ORDER BY `taskState`")
    fun findByName(value: Int): Maybe<List<DetailEntity>>

    @Insert
    fun insert(tasks: DetailEntity)

    @Delete
    fun delete(tasks: DetailEntity)

    @Update
    fun update(tasks: DetailEntity)

}

