package com.newsapp.enciyo.todoapp.ui.main

import com.newsapp.enciyo.todoapp.BaseView
import com.newsapp.enciyo.todoapp.model.modelDao.CardEntity

interface MainView {

  interface View :BaseView{
    fun initViews(list:List<CardEntity>)
    fun updateUI()
  }
  interface Presenter{

      fun getAllTodos(view: View)
      fun deleteTask(cardEntity: CardEntity)

  }

}