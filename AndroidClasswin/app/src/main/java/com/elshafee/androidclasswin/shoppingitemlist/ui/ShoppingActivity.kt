package com.elshafee.androidclasswin.shoppingitemlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elshafee.androidclasswin.R
import com.elshafee.androidclasswin.databinding.ActivityShoppingBinding
import com.elshafee.androidclasswin.shoppingitemlist.db.ShoppingDatabase
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem
import com.elshafee.androidclasswin.shoppingitemlist.repositry.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val database = ShoppingDatabase(this)
        val repositry = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repositry)
        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
        val shoppingAdapter =ShoppingAdapter(listOf(),viewModel)
        binding.rvShoppingItems.layoutManager= LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = shoppingAdapter

        viewModel.getAllShoppingItems().observe(this,Observer{shoppingIemsList ->
            shoppingAdapter.items = shoppingIemsList
            shoppingAdapter.notifyDataSetChanged()
        })

        binding.fbAddShoppingItem.setOnClickListener{
            AddShoppingItemDialog(this,object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }


    }
}