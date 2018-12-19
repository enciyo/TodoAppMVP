package com.newsapp.enciyo.todoapp.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [ModelEntity::class], version = 5,exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun modelDao(): ModelDao

    companion object {
        var INSTANCE: DatabaseManager? = null

        fun getDataBaseManager(context: Context): DatabaseManager? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
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