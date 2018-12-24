package com.newsapp.enciyo.todoapp.ui.cdetail

import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

interface CardDetailContract{

    interface Presenter{

        fun getCardTask(view: CardDetailContract.View,value:Int)
        fun deleteNote(detailEntity: DetailEntity)

    }

    interface View {
        fun onSucces()
        fun initView(list: List<DetailEntity>)
    }


}