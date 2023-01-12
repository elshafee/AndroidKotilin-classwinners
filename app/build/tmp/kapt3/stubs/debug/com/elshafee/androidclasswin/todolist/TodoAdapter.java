package com.elshafee.androidclasswin.todolist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/elshafee/androidclasswin/todolist/TodoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/elshafee/androidclasswin/todolist/TodoAdapter$TodoViewHolder;", "todos", "", "Lcom/elshafee/androidclasswin/todolist/Todos;", "(Ljava/util/List;)V", "getTodos", "()Ljava/util/List;", "setTodos", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TodoViewHolder", "app_debug"})
public final class TodoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.elshafee.androidclasswin.todolist.TodoAdapter.TodoViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.elshafee.androidclasswin.todolist.Todos> todos;
    
    public TodoAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.elshafee.androidclasswin.todolist.Todos> todos) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.elshafee.androidclasswin.todolist.Todos> getTodos() {
        return null;
    }
    
    public final void setTodos(@org.jetbrains.annotations.NotNull()
    java.util.List<com.elshafee.androidclasswin.todolist.Todos> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.elshafee.androidclasswin.todolist.TodoAdapter.TodoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.elshafee.androidclasswin.todolist.TodoAdapter.TodoViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/elshafee/androidclasswin/todolist/TodoAdapter$TodoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/elshafee/androidclasswin/databinding/ItemTodoBinding;", "(Lcom/elshafee/androidclasswin/todolist/TodoAdapter;Lcom/elshafee/androidclasswin/databinding/ItemTodoBinding;)V", "getBinding", "()Lcom/elshafee/androidclasswin/databinding/ItemTodoBinding;", "app_debug"})
    public final class TodoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.elshafee.androidclasswin.databinding.ItemTodoBinding binding = null;
        
        public TodoViewHolder(@org.jetbrains.annotations.NotNull()
        com.elshafee.androidclasswin.databinding.ItemTodoBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elshafee.androidclasswin.databinding.ItemTodoBinding getBinding() {
            return null;
        }
    }
}