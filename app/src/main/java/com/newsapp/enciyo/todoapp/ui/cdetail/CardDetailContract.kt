package com.newsapp.enciyo.todoapp.ui.cdetail

import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

interface CardDetailContract{

    interface Presenter{

        fun getCardTask(view: CardDetailContract.View,value:Int)
    }

    interface View {
        fun onSucces()
        fun LiveData(list: List<DetailEntity>)
    }


}