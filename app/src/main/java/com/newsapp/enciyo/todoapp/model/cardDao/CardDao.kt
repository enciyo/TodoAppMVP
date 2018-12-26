package com.newsapp.enciyo.todoapp.model.cardDao

import android.arch.persistence.room.*
import io.reactivex.Maybe

@Dao
interface CardDao {

        @Query("SELECT * FROM taskmodel ORDER BY `cardState`")
        fun getAllCard(): Maybe<List<CardEntity>>

        @Query("SELECT * FROM taskmodel where cardTitle LIKE  :name AND `cardDetail` LIKE :detail ORDER BY `cardState` DESC")
            fun findByName(name: String, detail: String): CardEntity

        @Insert
        fun insert(card: CardEntity)

        @Delete
        fun delete(card: CardEntity)

        @Update
        fun update(card:CardEntity)

}