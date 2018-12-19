package com.newsapp.enciyo.todoapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.newsapp.enciyo.todoapp.ui.addnote.AddNoteActivity
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.adapter.TodoListAdapter
import com.newsapp.enciyo.todoapp.model.modelDao.CardEntity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView.View {
    override fun LiveData(list: List<*>) {
        initViews(list as List<CardEntity>)
    }


    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter= MainPresenter(this@MainActivity, this)



        mAddButton.setOnClickListener {
            Util.mLog("MainAcitivty: mAddButton")
            startActivity(Intent(this, AddNoteActivity::class.java))
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
        mRecyclerView.layoutManager= GridLayoutManager(this,2)
        mRecyclerView.adapter= TodoListAdapter(this, list,presenter)
    }


}
