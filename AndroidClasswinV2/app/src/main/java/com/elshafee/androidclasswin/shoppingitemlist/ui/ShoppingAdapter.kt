package com.elshafee.androidclasswin.shoppingitemlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elshafee.androidclasswin.databinding.ItemShoppingBinding
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem

class ShoppingAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHoplder>() {
    inner class ShoppingViewHoplder(val binding: ItemShoppingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHoplder {
        return ShoppingViewHoplder(
            ItemShoppingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShoppingViewHoplder, position: Int) {
        var currentShoppingItem = items[position]
        holder.binding.txShoppingItemName.text = currentShoppingItem.name
        holder.binding.txShoppingItemAmount.text = "${currentShoppingItem.amount}"
        holder.binding.ivShoppingItemDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }
        holder.binding.ivShoppingItemADD.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }
        holder.binding.ivShoppingItemMinus.setOnClickListener {
            if (currentShoppingItem.amount > 1) {
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            } else if (currentShoppingItem.amount == 1) {
                viewModel.delete(currentShoppingItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}