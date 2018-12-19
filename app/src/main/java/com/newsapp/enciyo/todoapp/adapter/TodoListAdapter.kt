package com.newsapp.enciyo.todoapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.ModelEntity
import com.newsapp.enciyo.todoapp.ui.main.MainView
import kotlinx.android.synthetic.main.item_list.view.*

class TodoListAdapter(val context:Context,val list:List<ModelEntity>,val presenter:MainView.Presenter) : RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list,p0,false)
        return MyViewHolder(view,presenter)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.setData(list[p1])
        Util.mLog("Hata")
    }


    class MyViewHolder(itemView:View, private val presenter: MainView.Presenter) : RecyclerView.ViewHolder(itemView){

        fun setData(modelEntity: ModelEntity) {
            itemView.apply {
                mListTitle.text = modelEntity.title
                mListDesc.text = modelEntity.detail
                mListTag.text=modelEntity.tag

                mListCheck.setOnClickListener {
                    presenter.deleteTask(modelEntity)
                }
            }

        }

    }
}