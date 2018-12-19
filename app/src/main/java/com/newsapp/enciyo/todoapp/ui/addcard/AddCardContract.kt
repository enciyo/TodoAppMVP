package com.newsapp.enciyo.todoapp.ui.addcard

import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity

interface AddCardContract {

    interface Presenter{
        fun saveCardDatabase(cardEntity: CardEntity)
    }
    interface View{
        fun onSucces()
    }
}