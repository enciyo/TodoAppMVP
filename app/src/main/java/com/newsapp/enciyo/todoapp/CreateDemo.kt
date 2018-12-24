package com.newsapp.enciyo.todoapp

import android.content.Context
import com.newsapp.enciyo.todoapp.model.cardDao.CardEntity
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity

object CreateDemo {

    fun addCard(context: Context) {
        val inject = Injection.provideCardDoa(context)
        inject.apply {
            insert(CardEntity(Math.random().toInt(), "Work", "Monday"))
            insert(CardEntity(Math.random().toInt(), "Travel Guide", "Summer"))
            insert(CardEntity(Math.random().toInt(), "Engineering", "EverDay"))
            insert(CardEntity(Math.random().toInt(), "Homeworks", "EveryDay"))
            insert(CardEntity(Math.random().toInt(), "To-Do", "EveryDay"))
            insert(CardEntity(Math.random().toInt(), "Personel Evolution", "EveryDay"))
            insert(CardEntity(Math.random().toInt(), "Business Trip", "Saturday"))
            insert(CardEntity(Math.random().toInt(), "Picnic", "Weekend"))
            insert(CardEntity(Math.random().toInt(), "Book Notes", "Book"))
            insert(CardEntity(Math.random().toInt(), "Business Notes", "Business"))
        }
    }

    fun addDetail(context: Context, reference: Int) {
        val inject2 = Injection.provideDetailDao(context)
        inject2.apply {
            insert(DetailEntity(Math.random().toInt(),reference,"Room library","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"Dagger 2","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"MVP Pattern","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"MVVM Pattern","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"Retrofit","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"Rx","Kotlin"))
            insert(DetailEntity(Math.random().toInt(),reference,"Bloc Pattern","Flutter"))
            insert(DetailEntity(Math.random().toInt(),reference,"Json serialization","Flutter"))
        }
    }

}