package com.newsapp.enciyo.todoapp.model.cardDao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Maybe

@Dao
interface CardDao {

        @Query("SELECT * FROM taskmodel")
        fun getAllCard(): Maybe<List<CardEntity>>

        @Query("SELECT * FROM taskmodel where cardTitle LIKE  :name AND `cardDetail` LIKE :detail")
            fun findByName(name: String, detail: String): CardEntity

        @Insert
        fun insert(card: CardEntity)

        @Delete
        fun delete(card: CardEntity)

}