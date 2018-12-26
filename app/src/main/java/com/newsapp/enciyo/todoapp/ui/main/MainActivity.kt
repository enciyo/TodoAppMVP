package com.newsapp.enciyo.todoapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.newsapp.enciyo.todoapp.CreateDemo
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Extensions
import com.newsapp.enciyo.todoapp.adapter.MainItemTouchHelper
import com.newsapp.enciyo.todoapp.adapter.MainListAdapter
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.ui.addcard.AddCardActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView.View,View.OnClickListener{


    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter= MainPresenter(this@MainActivity, this)
        mAddButton.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        Extensions.mLog("MainAcitivty: mAddButton")
        CreateDemo.addCard(this)
        startActivity(Intent(this, AddCardActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun updateUI() {
        Extensions.mLog("MainActivity: updateUI")
        presenter.getAllTodos(this)
    }

    override fun initViews(list:List<CardEntity>) {
        Extensions.mLog("MainAcitivty: initViews")
        val grid = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        mRecyclerView.layoutManager= grid
        val adapter=MainListAdapter(this,list,presenter)
        mRecyclerView.adapter= adapter
        ItemTouchHelper(MainItemTouchHelper(adapter)).attachToRecyclerView(mRecyclerView)


    }


}
