package com.newsapp.enciyo.todoapp.ui.cdetail

import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

interface CardDetailContract{

    interface Presenter{

        fun addTask(detailEntity: DetailEntity)
    }

    interface View{


    }


}