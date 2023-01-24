package com.elshafee.androidclasswin.shoppingitemlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elshafee.androidclasswin.shoppingitemlist.repositry.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}