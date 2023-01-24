package com.elshafee.androidclasswin.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elshafee.androidclasswin.R

class TodolistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)
        val recyclerView = findViewById<RecyclerView>(R.id.rvTodos)
        val todobtn = findViewById<Button>(R.id.btnAddTodo)
        val todoet = findViewById<EditText>(R.id.etAddTodo)

        val todoListItems = mutableListOf(
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
            Todos("Do Android Session",false),
        )
        val adapter = TodoAdapter(todoListItems)

        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)

        todobtn.setOnClickListener{
            var title:String = todoet.text.toString()
           var newtodo = Todos(title,false)
            todoListItems.add(newtodo)
            todoet.text.clear()
            adapter.notifyDataSetChanged()
        }

    }
}