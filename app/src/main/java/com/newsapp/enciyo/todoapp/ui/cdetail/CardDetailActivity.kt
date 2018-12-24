package com.newsapp.enciyo.todoapp.ui.cdetail

import android.content.Intent
import android.content.Intent.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.adapter.DetailListAdapter
import com.newsapp.enciyo.todoapp.addCardDemo
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import com.newsapp.enciyo.todoapp.ui.addnote.AddNoteActivity
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity(), CardDetailContract.View {

    val presenter = CardDetailPresenter(this, this)
    var cardId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        textHeader.text = intent.extras!!["keyTitle"]!!.toString()
        textDetail.text = intent.extras!!["keyDetail"]!!.toString()
        this.cardId = intent.getStringExtra("keyId").toInt()


        mAddButton.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java).putExtra("CardId", cardId.toString()))
           // addCardDemo.addDetail(this,cardId!!)
            //onSucces()
        }

    }

    override fun onSucces() {
        Util.mLog("CardDetailActivity: onSucces")
        presenter.getCardTask(this, cardId)
    }

    override fun LiveData(list: List<DetailEntity>) {
        mRecyclerViewDetail.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mRecyclerViewDetail.adapter = DetailListAdapter(this, list, presenter)
    }

    override fun onResume() {
        super.onResume()
        presenter.getCardTask(this, cardId!!)
    }
}
