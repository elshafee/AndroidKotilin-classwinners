package com.elshafee.androidclasswin.shoppingitemlist.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\n"}, d2 = {"Lcom/elshafee/androidclasswin/shoppingitemlist/db/ShoppingDao;", "", "delete", "", "item", "Lcom/elshafee/androidclasswin/shoppingitemlist/model/ShoppingItem;", "getAllShoppingItem", "Landroidx/lifecycle/LiveData;", "", "upsert", "app_debug"})
public abstract interface ShoppingDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void upsert(@org.jetbrains.annotations.NotNull()
    com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem item);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem item);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM shopping_items")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem>> getAllShoppingItem();
}