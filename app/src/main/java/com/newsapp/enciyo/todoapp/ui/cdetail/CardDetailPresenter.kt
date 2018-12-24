package com.newsapp.enciyo.todoapp.ui.cdetail

import android.content.Context
import com.newsapp.enciyo.todoapp.Injection
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CardDetailPresenter(val view:CardDetailContract.View,val context: Context) : CardDetailContract.Presenter {

    val dao = Injection.provideDetailDao(context)

    override fun getCardTask(view: CardDetailContract.View,value:Int) {
        CompositeDisposable().add(dao.findByName(value)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.LiveData(it)
            }
        )
    }

    override fun deleteNote(detailEntity: DetailEntity) {
        dao.delete(detailEntity)
        view.onSucces()
    }


}