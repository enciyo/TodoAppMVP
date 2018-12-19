package com.newsapp.enciyo.todoapp.ui.addnote

import android.content.Context
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.DatabaseManager
import com.newsapp.enciyo.todoapp.model.ModelEntity
import com.newsapp.enciyo.todoapp.ui.addnote.AddNoteContract

class AddNotePresenter(val context: Context,val view: AddNoteContract.View) : AddNoteContract.Presenter{

    var manager:DatabaseManager = DatabaseManager.getDataBaseManager(context)!!

    override fun saveDatebase(modelEntity: ModelEntity, view: AddNoteContract.View) {
        Util.mLog("AddNotePresenter: saveDatabase")
        manager.modelDao().insert(modelEntity)
        view.onSucces()
    }


}