package com.newsapp.enciyo.todoapp.ui.main

import com.newsapp.enciyo.todoapp.model.ModelEntity

interface MainView {

  interface View {
    fun initViews(list:List<ModelEntity>)
    fun updateUI()
  }
  interface Presenter{

      fun getAllTodos(view: View)
      fun deleteTask(modelEntity: ModelEntity)

  }

}