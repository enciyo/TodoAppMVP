package com.newsapp.enciyo.todoapp.ui.addcard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import kotlinx.android.synthetic.main.activity_add_card.*

class AddCardActivity : AppCompatActivity(), AddCardContract.View, View.OnClickListener {


    val presenter = AddCardPresenter(this, this@AddCardActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        mCardSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        presenter.saveCardDatabase(CardEntity(Math.random().toInt(), mTitle.text.toString(), mDetail.text.toString()))
    }

    override fun onSucces() {
        Util.mLog("AddCardActivity: onSucces")
        finish()
    }

}

