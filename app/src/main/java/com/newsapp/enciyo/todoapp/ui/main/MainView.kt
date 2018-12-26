package com.newsapp.enciyo.todoapp.ui.main

import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity

interface MainView {

  interface View {
    fun initViews(list:List<CardEntity>)
    fun updateUI()
  }
  interface Presenter{

      fun getAllTodos(view: View)
      fun deleteTask(cardEntity: CardEntity)
      fun updateTask(cardEntity: CardEntity)

  }

}