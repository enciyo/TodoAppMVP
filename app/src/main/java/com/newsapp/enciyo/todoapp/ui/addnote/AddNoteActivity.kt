package com.newsapp.enciyo.todoapp.ui.addnote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.newsapp.enciyo.todoapp.R
import com.newsapp.enciyo.todoapp.Util
import com.newsapp.enciyo.todoapp.model.ModelEntity
import com.newsapp.enciyo.todoapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.add_note_acv.*

class AddNoteActivity : AppCompatActivity(),View.OnClickListener, AddNoteContract.View {

     private val presenter= AddNotePresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note_acv)

        mSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Util.mLog("AddNoteActivity: onClicked")
        presenter.saveDatebase(ModelEntity(0,mGetTittle.text.toString(),mGetDetail.text.toString(),"#"+mGetTag.text.toString()),this)
    }

    override fun onSucces() {
        Util.mLog("AddNoteActivity: onSucces")
        startActivity(Intent(this,MainActivity::class.java))
    }
}
