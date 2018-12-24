package com.newsapp.enciyo.todoapp

import android.content.Context
import android.util.Log
import android.widget.Toast

object Extensions {
    private val mLogger: String = "MyLogger"

    fun mLog(value: String) {
        Log.i(mLogger,value)
    }

    fun mToast(context:Context,value:String){
        Toast.makeText(context,value,Toast.LENGTH_SHORT).show()
    }

}