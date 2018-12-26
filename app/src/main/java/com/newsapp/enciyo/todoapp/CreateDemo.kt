package com.newsapp.enciyo.todoapp

import android.content.Context
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

object CreateDemo {

    fun addCard(context: Context) {
        val inject = Injection.provideCardDoa(context)
        inject.apply {
            insert(CardEntity(Math.random().toInt(), "Work", "Monday",0))
            insert(CardEntity(Math.random().toInt(), "Travel Guide", "Summer",0))
            insert(CardEntity(Math.random().toInt(), "Engineering", "EverDay",0))
            insert(CardEntity(Math.random().toInt(), "Homeworks", "EveryDay",0))
            insert(CardEntity(Math.random().toInt(), "To-Do", "EveryDay",0))
            insert(CardEntity(Math.random().toInt(), "Personel Evolution", "EveryDay",0))
            insert(CardEntity(Math.random().toInt(), "Business Trip", "Saturday",0))
            insert(CardEntity(Math.random().toInt(), "Picnic", "Weekend",0))
            insert(CardEntity(Math.random().toInt(), "Book Notes", "Book",0))
            insert(CardEntity(Math.random().toInt(), "Business Notes", "Business",0))
        }
    }

    fun addDetail(context: Context, reference: Int) {
        val inject2 = Injection.provideDetailDao(context)
        inject2.apply {
            insert(DetailEntity(Math.random().toInt(),reference,"Room library","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"Dagger 2","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"MVP Pattern","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"MVVM Pattern","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"Retrofit","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"Rx","Kotlin",0))
            insert(DetailEntity(Math.random().toInt(),reference,"Bloc Pattern","Flutter",0))
            insert(DetailEntity(Math.random().toInt(),reference,"Json serialization","Flutter",0))
        }
    }

}