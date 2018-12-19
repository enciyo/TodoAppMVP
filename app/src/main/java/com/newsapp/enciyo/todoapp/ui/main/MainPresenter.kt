package com.newsapp.enciyo.todoapp.ui.main

import android.content.Context
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.DatabaseManager
import com.newsapp.enciyo.todoapp.model.ModelEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainView.View, val context: Context) :
    MainView.Presenter {


    var databaseManager: DatabaseManager = DatabaseManager.getDataBaseManager(context)!!


    override fun getAllTodos(view: MainView.View) {
        Util.mLog("MainPresenter: getAllTodos")
        CompositeDisposable().add(databaseManager.modelDao().getAllBook()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.initViews(it)
            }
        )
    }

    override fun deleteTask(modelEntity: ModelEntity) {
        Util.mLog("MainPresenter: deleteTask")
        databaseManager.modelDao().delete(modelEntity)
        view.updateUI()
    }


}