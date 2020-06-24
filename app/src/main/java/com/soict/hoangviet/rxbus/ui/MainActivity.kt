package com.soict.hoangviet.rxbus.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soict.hoangviet.rxbus.adapter.PersonAdapter
import com.soict.hoangviet.rxbus.R
import com.soict.hoangviet.rxbus.rxbus.RxBus
import com.soict.hoangviet.rxbus.rxbus.RxEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var personAdapter: PersonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        initListener()
    }

    private fun initListener() {
        fab_add_person.setOnClickListener {
            startActivity(Intent(this, AddingPersonActivity::class.java))
        }
        RxBus.listen(RxEvent.EventAddingPerson::class.java).subscribe {
            personAdapter.addModel(it.name)
        }
    }

    private fun initAdapter() {
        personAdapter = PersonAdapter(this)
        val listPerson = mutableListOf("John", "Marry", "Susan", "Antonio", "Mount")
        rcv_person.adapter = personAdapter
        rcv_person.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        personAdapter.addModels(listPerson)
    }
}
