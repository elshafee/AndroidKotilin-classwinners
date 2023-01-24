package com.elshafee.androidclasswin.breakingbadapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.elshafee.androidclasswin.breakingbadapi.repositry.CharacterRepositry
import kotlinx.coroutines.launch

class CharacterListViewModel(private  val characterRepositry: CharacterRepositry):ViewModel() {

    init {
        refreshDataFromREpository()
    }

    val characterList = characterRepositry.characters

    fun refreshDataFromREpository(){
        viewModelScope.launch {
            characterRepositry.refreshCharacter()
        }
    }

}

class CharacterListViewModelFactory(private val characterRepositry: CharacterRepositry):
        ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CharacterListViewModel::class.java)){
            return CharacterListViewModel(characterRepositry) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")

    }
        }