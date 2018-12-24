package com.newsapp.enciyo.todoapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.ui.addnote.AddNoteActivity
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.adapter.TodoListAdapter
import com.newsapp.enciyo.todoapp.addCardDemo
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.ui.addcard.AddCardActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView.View {
    override fun LiveData(list: List<CardEntity>) {
        initViews(list )
    }


    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= MainPresenter(this@MainActivity, this)



        mAddButton.setOnClickListener {
            Util.mLog("MainAcitivty: mAddButton")
            startActivity(Intent(this, AddCardActivity::class.java))
           // addCardDemo.addDemo(this)
           // updateUI()
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun updateUI() {
        Util.mLog("MainActivity: updateUI")
        presenter.getAllTodos(this)
    }

    override fun initViews(list:List<CardEntity>) {
        Util.mLog("MainAcitivty: initViews")
        val grid = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        mRecyclerView.layoutManager= grid
        mRecyclerView.adapter= TodoListAdapter(this, list,presenter)
    }


}
