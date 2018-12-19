package com.newsapp.enciyo.todoapp.ui.addnote

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.modelDao.CardEntity

class AddNotePresenter(val context: Context,val view: AddNoteContract.View) : AddNoteContract.Presenter{


    val dao= Injection.provideCardDoa(context)

    override fun saveDatebase(cardEntity: CardEntity, view: AddNoteContract.View) {
        Util.mLog("AddNotePresenter: saveDatabase")
        dao.insert(cardEntity)
        view.onSucces()
    }


}