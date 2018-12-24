package com.newsapp.enciyo.todoapp.ui.addnote


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.detailDao.DetailEntity
import kotlinx.android.synthetic.main.add_note_acv.*

class AddNoteActivity : AppCompatActivity(), View.OnClickListener, AddNoteContract.View {

    lateinit var presenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note_acv)

        presenter = AddNotePresenter(this, this)
        mSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Util.mLog("AddNoteActivity: onClicked")
        presenter.saveDatebase(
            DetailEntity(
                Math.random().toInt(),
                intent.getStringExtra("CardId").toInt(),
                mGetTittle.text.toString(),
                mGetDetail.text.toString()
            ), this
        )
    }

    override fun onSucces() {
        Util.mLog("AddNoteActivity: onSucces")
        finish()
    }


}
