package com.elshafee.androidclasswin.shoppingitemlist.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingAdapter$ShoppingViewHoplder;", "items", "", "Lcom/elshafee/androidclasswin/shoppingitemlist/model/ShoppingItem;", "viewModel", "Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingViewModel;", "(Ljava/util/List;Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingViewModel;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ShoppingViewHoplder", "app_debug"})
public final class ShoppingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingAdapter.ShoppingViewHoplder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem> items;
    private final com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingViewModel viewModel = null;
    
    public ShoppingAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem> items, @org.jetbrains.annotations.NotNull()
    com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingViewModel viewModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingAdapter.ShoppingViewHoplder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.elshafee.androidclasswin.shoppingitemlist.ui.ShoppingAdapter.ShoppingViewHoplder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingAdapter$ShoppingViewHoplder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/elshafee/androidclasswin/databinding/ItemShoppingBinding;", "(Lcom/elshafee/androidclasswin/shoppingitemlist/ui/ShoppingAdapter;Lcom/elshafee/androidclasswin/databinding/ItemShoppingBinding;)V", "getBinding", "()Lcom/elshafee/androidclasswin/databinding/ItemShoppingBinding;", "app_debug"})
    public final class ShoppingViewHoplder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.elshafee.androidclasswin.databinding.ItemShoppingBinding binding = null;
        
        public ShoppingViewHoplder(@org.jetbrains.annotations.NotNull()
        com.elshafee.androidclasswin.databinding.ItemShoppingBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elshafee.androidclasswin.databinding.ItemShoppingBinding getBinding() {
            return null;
        }
    }
}