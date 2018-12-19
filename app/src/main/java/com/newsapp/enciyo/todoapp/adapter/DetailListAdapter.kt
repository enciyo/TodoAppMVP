package com.newsapp.enciyo.todoapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import kotlinx.android.synthetic.main.activity_add_card.view.*
import kotlinx.android.synthetic.main.item_list.view.*

class DetailListAdapter(val context: Context,val list: List<DetailEntity> ) : RecyclerView.Adapter<DetailListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.setData(list[p1])
    }


    class MyViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){


        fun setData(list:DetailEntity){
            itemView.apply {
                mListTitle.text=list.taskTitle
                mListDesc.text=list.taskDetail
            }
        }
    }
}