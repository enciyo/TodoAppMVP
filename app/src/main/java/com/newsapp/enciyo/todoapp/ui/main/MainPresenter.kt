package com.newsapp.enciyo.todoapp.ui.main

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainView.View, val context: Context) :
    MainView.Presenter {


    val dao = Injection.provideCardDoa(context)

    override fun getAllTodos(view: MainView.View) {
        Util.mLog("MainPresenter: getAllTodos")
        CompositeDisposable().add(dao.getAllCard()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.initViews(it)
            }
        )
    }

    override fun deleteTask(cardEntity: CardEntity) {
        Util.mLog("MainPresenter: deleteTask")
        dao.delete(cardEntity)
        view.updateUI()
    }


}