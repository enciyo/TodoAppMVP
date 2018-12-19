package com.newsapp.enciyo.todoapp

import android.content.Context
import com.newsapp.enciyo.todoapp.model.DatabaseManager
import com.newsapp.enciyo.todoapp.model.modelDao.CardDao
import com.newsapp.enciyo.todoapp.model.detailDao.DetailDao

object Injection{

    fun provideCardDoa(context: Context): CardDao {
        val database = DatabaseManager.getDataBaseManager(context)
        return database!!.modelDao()
    }

    fun provideDetailDao(context: Context):DetailDao{
        val database2 = DatabaseManager.getDataBaseManager(context)
        return database2!!.detailDao()
    }


}