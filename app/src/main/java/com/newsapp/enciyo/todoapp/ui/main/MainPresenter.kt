package com.newsapp.enciyo.todoapp.ui.main

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.ModelEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainView.View, val context: Context) :
    MainView.Presenter {


    val dao = Injection.provideDataManager(context)

    override fun getAllTodos(view: MainView.View) {
        Util.mLog("MainPresenter: getAllTodos")
        CompositeDisposable().add(dao.getAllBook()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.initViews(it)
            }
        )
    }

    override fun deleteTask(modelEntity: ModelEntity) {
        Util.mLog("MainPresenter: deleteTask")
        dao.delete(modelEntity)
        view.updateUI()
    }


}