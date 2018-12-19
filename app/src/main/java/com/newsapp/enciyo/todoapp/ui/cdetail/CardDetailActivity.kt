package com.newsapp.enciyo.todoapp.ui.cdetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.newsapp.enciyo.todoapp.R
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        textHeader.text=intent.extras["txtHeader"].toString()


    }
}
