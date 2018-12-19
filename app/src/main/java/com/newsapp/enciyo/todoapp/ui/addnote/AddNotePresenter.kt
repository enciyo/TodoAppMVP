package com.newsapp.enciyo.todoapp.ui.addnote

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.ModelEntity

class AddNotePresenter(val context: Context,val view: AddNoteContract.View) : AddNoteContract.Presenter{


    val dao= Injection.provideDataManager(context)

    override fun saveDatebase(modelEntity: ModelEntity, view: AddNoteContract.View) {
        Util.mLog("AddNotePresenter: saveDatabase")
        dao.insert(modelEntity)
        view.onSucces()
    }


}