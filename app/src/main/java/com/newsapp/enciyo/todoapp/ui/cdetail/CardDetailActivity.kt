package com.newsapp.enciyo.todoapp.ui.cdetail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.newsapp.enciyo.todoapp.CreateDemo
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Extensions
import com.newsapp.enciyo.todoapp.adapter.DetailItemTouchHelper
import com.newsapp.enciyo.todoapp.adapter.DetailListAdapter
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import com.newsapp.enciyo.todoapp.ui.addnote.AddNoteActivity
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity(), CardDetailContract.View, View.OnClickListener {
    override fun onClick(v: View?) {
       // CreateDemo.addDetail(this, this.cardId)
        startActivity(Intent(this, AddNoteActivity::class.java).putExtra("CardId", cardId.toString()))

    }

    val presenter = CardDetailPresenter(this, this)
    var cardId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        textHeader.text = intent.extras!!["keyTitle"]!!.toString()
        textDetail.text = intent.extras!!["keyDetail"]!!.toString()
        this.cardId = intent.getStringExtra("keyId").toInt()

        mAddButton.setOnClickListener(this)

    }

    override fun onSucces() {
        Extensions.mLog("CardDetailActivity: onSucces")
        presenter.getCardTask(this, cardId)
    }

    override fun initView(list: List<DetailEntity>) {
        val adapter = DetailListAdapter(this, list, presenter)
        mRecyclerViewDetail.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mRecyclerViewDetail.adapter = adapter
        ItemTouchHelper(DetailItemTouchHelper(adapter)).attachToRecyclerView(mRecyclerViewDetail)
    }

    override fun onResume() {
        super.onResume()
        presenter.getCardTask(this, cardId)
    }
}
