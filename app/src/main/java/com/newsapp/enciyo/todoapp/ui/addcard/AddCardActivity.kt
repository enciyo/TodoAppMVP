package com.newsapp.enciyo.todoapp.ui.addcard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_add_card.*

class AddCardActivity : AppCompatActivity(),AddCardContract.View,View.OnClickListener{
    override fun onClick(v: View?) {
        presenter.saveCardDatabase(CardEntity(Math.random().toInt(),mTitle.text.toString(),mDetail.text.toString()))
    }

    override fun onSucces() {
            Util.mLog("AddCardActivity: onSucces")
            startActivity(Intent(this,MainActivity::class.java))
    }


    val presenter = AddCardPresenter(this,this@AddCardActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        mCardSave.setOnClickListener(this)
    }
}

