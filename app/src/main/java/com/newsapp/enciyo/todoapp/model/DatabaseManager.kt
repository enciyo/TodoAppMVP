package com.newsapp.enciyo.todoapp.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.newsapp.enciyo.todoapp.model.cardDao.CardDao
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.model.detailDao.DetailDao
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity


@Database(entities = [CardEntity::class,DetailEntity::class], version = 13,exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun modelDao(): CardDao
    abstract fun detailDao():DetailDao

    companion object {
        var INSTANCE: DatabaseManager? = null

        fun getDataBaseManager(context: Context): DatabaseManager? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabaseManager::class.java,
                    "task-data"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }

    }

}