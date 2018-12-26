package com.newsapp.enciyo.todoapp.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class MainItemTouchHelper(val adapter: MainListAdapter) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {


    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        return true
    }

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        adapter.onSwiped(p0, p1)
    }


    interface RcyItemTouchListener {
        fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int)
    }
}


