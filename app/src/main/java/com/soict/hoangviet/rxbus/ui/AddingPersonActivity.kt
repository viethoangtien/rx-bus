package com.soict.hoangviet.rxbus.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soict.hoangviet.rxbus.R
import com.soict.hoangviet.rxbus.rxbus.RxBus
import com.soict.hoangviet.rxbus.rxbus.RxEvent
import kotlinx.android.synthetic.main.activity_adding_person.*

class AddingPersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_person)
        initListener()
    }

    private fun initListener() {
        btn_add.setOnClickListener {
            when {
                edt_name.text.toString().isNullOrEmpty() -> {
                    Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    RxBus.publish(RxEvent.EventAddingPerson(edt_name.text.toString()))
                    finish()
                }
            }
        }
    }
}