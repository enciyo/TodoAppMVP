package com.newsapp.enciyo.todoapp.ui.addnote

import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

interface AddNoteContract{

    interface Presenter{
        fun saveDatebase(detailEntity: DetailEntity, view: View)
    }

    interface View{
        fun onSucces()
    }
}