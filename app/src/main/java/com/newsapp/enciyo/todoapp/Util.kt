package com.newsapp.enciyo.todoapp

import android.util.Log

object Util {
    private val mLogger: String = "MyLogger"

    fun mLog(value: String) {
        Log.i(mLogger,value)
    }
}