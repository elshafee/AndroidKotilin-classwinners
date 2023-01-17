package com.elshafee.androidclasswin.shoppingitemlist.repositry

import com.elshafee.androidclasswin.shoppingitemlist.db.ShoppingDatabase
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {
    fun upsert(item: ShoppingItem) = db.getShopingDao().upsert(item)
    fun delete(item: ShoppingItem) = db.getShopingDao().delete(item)
    fun getAllShoppingItem() = db.getShopingDao().getAllShoppingItem()

}