package com.newsapp.enciyo.todoapp

import android.content.Context
import com.newsapp.enciyo.todoapp.model.DatabaseManager
import com.newsapp.enciyo.todoapp.model.ModelDao

object Injection{

    fun provideDataManager(context: Context):ModelDao{
        val database = DatabaseManager.getDataBaseManager(context)
        return database!!.modelDao()
    }

}