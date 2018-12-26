package com.newsapp.enciyo.todoapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Extensions
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.ui.cdetail.CardDetailActivity
import com.newsapp.enciyo.todoapp.ui.main.MainView
import kotlinx.android.synthetic.main.item_list.view.*

class MainListAdapter(val context: Context, val list: List<CardEntity>, val presenter: MainView.Presenter) :
    RecyclerView.Adapter<MainListAdapter.MyViewHolder>(), MainItemTouchHelper.RcyItemTouchListener {

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
        (viewHolder as MyViewHolder).removeData()
        Log.i("Swipe", "Swipeeee")
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, p0, false)
        return MyViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.cardEntity = list[p1]
        p0.setData()
        Extensions.mLog("Hata")
    }


    class MyViewHolder(itemView: View, private val presenter: MainView.Presenter) : RecyclerView.ViewHolder(itemView) {
        lateinit var cardEntity: CardEntity

        fun removeData() {
            presenter.deleteTask(cardEntity)
        }

        fun setData() {
            itemView.apply {
                mListTitle.text = cardEntity.cardTitle
                mListDesc.text = cardEntity.cardDetail


                if (cardEntity.cardState == 1) {
                    mCheck.isChecked=true
                } else if(cardEntity.cardState==0) {
                    mCheck.isChecked=false
                }

                setOnLongClickListener {
                    presenter.deleteTask(cardEntity)
                    it.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                    true
                }

                setOnClickListener {
                    val intent = Intent(context, CardDetailActivity::class.java)
                    intent.apply {
                        putExtra("keyTitle", cardEntity.cardTitle)
                        putExtra("keyId", cardEntity.cardId.toString())
                        putExtra("keyDetail", cardEntity.cardDetail.toString())
                    }
                    context.startActivity(intent)
                }

                mCheck.setOnClickListener {
                    if (cardEntity.cardState == 1) {
                        cardEntity.cardState = 0
                        presenter.updateTask(cardEntity)

                    } else {
                        cardEntity.cardState = 1
                        presenter.updateTask(cardEntity)
                    }
                }


            }

        }

    }
}