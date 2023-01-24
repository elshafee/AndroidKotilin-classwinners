package  com.elshafee.androidclasswin.shoppingitemlist.ui

import androidx.lifecycle.ViewModel
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem
import com.elshafee.androidclasswin.shoppingitemlist.repositry.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel(){
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllShoppingItems() = repository.getAllShoppingItem()

}