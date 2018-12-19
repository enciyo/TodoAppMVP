package com.newsapp.enciyo.todoapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DetailListAdapter(val context: Context,val list: List<Any> ) : RecyclerView.Adapter<DetailListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(null,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.setData(list[p1])
    }


    class MyViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){


        fun setData(list:Any){

        }
    }
}