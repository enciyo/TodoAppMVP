package com.newsapp.enciyo.todoapp.ui.addcard

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.model.cardDao.CardDao
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity

class AddCardPresenter(val context: Context,val view: AddCardContract.View) : AddCardContract.Presenter{

    val dao = Injection.provideCardDoa(context)

    override fun saveCardDatabase(cardEntity: CardEntity) {
            dao.insert(cardEntity)
            view.onSucces()
    }

}