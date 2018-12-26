package com.newsapp.enciyo.todoapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import com.newsapp.enciyo.todoapp.ui.cdetail.CardDetailContract
import kotlinx.android.synthetic.main.detail_item.view.*
import kotlinx.android.synthetic.main.item_list.view.*

class DetailListAdapter(
    val context: Context,
    val list: List<DetailEntity>,
    val presenter: CardDetailContract.Presenter
) : RecyclerView.Adapter<DetailListAdapter.MyViewHolder>(),
    DetailItemTouchHelper.DetailItemTouchListener {

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as MyViewHolder).removeCard()
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.detail_item, p0, false)
        return MyViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.detailEntity = list[p1]
        p0.setData()
    }


    class MyViewHolder(itemview: View, val presenter: CardDetailContract.Presenter) :
        RecyclerView.ViewHolder(itemview) {
        lateinit var detailEntity: DetailEntity

        fun removeCard() {
            presenter.deleteNote(detailEntity)
        }

        fun setData() {
            itemView.apply {
                mTitle.text = detailEntity.taskTitle
                mDesc.text = detailEntity.taskDetail
            }
            if (detailEntity.taskState == 1) {
                itemView.mListCheck.isChecked=true
            }else if(detailEntity.taskState==0) {
                itemView.mListCheck.isChecked=false
            }
            itemView.mListCheck.setOnClickListener {

                if (detailEntity.taskState == 1) {
                    detailEntity.taskState = 0
                    presenter.updateNote(detailEntity)

                } else {
                    detailEntity.taskState = 1
                    presenter.updateNote(detailEntity)
                }
            }


        }
    }
}