package com.newsapp.enciyo.todoapp.ui.addnote

import com.newsapp.enciyo.todoapp.model.modelDao.CardEntity

interface AddNoteContract{

    interface Presenter{
        fun saveDatebase(cardEntity: CardEntity, view: View)
    }

    interface View{
        fun onSucces()
    }
}