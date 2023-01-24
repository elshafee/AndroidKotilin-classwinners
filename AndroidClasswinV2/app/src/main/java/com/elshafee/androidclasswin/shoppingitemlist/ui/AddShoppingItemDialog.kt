package com.elshafee.androidclasswin.shoppingitemlist.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.elshafee.androidclasswin.R
import com.elshafee.androidclasswin.databinding.ActivityAddShoppingItemDialogBinding
import com.elshafee.androidclasswin.databinding.ItemShoppingBinding
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem

class AddShoppingItemDialog(conext: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(conext) {
    private lateinit var binding: ActivityAddShoppingItemDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddShoppingItemDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnShoppingDialogADD.setOnClickListener{
            var shoppingItemName = binding.etShoppingItemDialogName.text.toString()
            var shoppingItemAmount = binding.etShoppingItemDialogAmount.text.toString()

            if (shoppingItemName.isNotEmpty() && shoppingItemAmount.isNotEmpty()){
                var item = ShoppingItem(shoppingItemName, shoppingItemAmount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }else{
                Toast.makeText(context, "Please enter iem Name and amount",Toast.LENGTH_SHORT).show()
            return@setOnClickListener
            }

        }
        binding.btnShoppingDialogCancel.setOnClickListener{
            cancel()
        }
    }
}