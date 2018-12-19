package com.newsapp.enciyo.todoapp.ui.addnote

import com.newsapp.enciyo.todoapp.model.ModelEntity

interface AddNoteContract{

    interface Presenter{
        fun saveDatebase(modelEntity: ModelEntity,view: View)
    }

    interface View{
        fun onSucces()
    }
}