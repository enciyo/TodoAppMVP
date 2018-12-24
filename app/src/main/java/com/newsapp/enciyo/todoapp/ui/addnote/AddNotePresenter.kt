package com.newsapp.enciyo.todoapp.ui.addnote

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.Extensions
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

class AddNotePresenter(val context: Context,val view: AddNoteContract.View) : AddNoteContract.Presenter{


    val dao= Injection.provideDetailDao(context)

    override fun saveDatebase(detailEntity: DetailEntity, view: AddNoteContract.View) {
        Extensions.mLog("AddNotePresenter: saveDatabase")
        dao.insert(detailEntity)
        view.onSucces()
    }


}