package com.elshafee.androidclasswin.breakingbadapi.repositry

import androidx.lifecycle.LiveData
import com.elshafee.androidclasswin.breakingbadapi.db.CharacterDao
import com.elshafee.androidclasswin.breakingbadapi.model.BreakingBadCharacters
import com.elshafee.androidclasswin.breakingbadapi.services.BreakingBadNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepositry(private val characterDao: CharacterDao) {

    var characters:LiveData<List<BreakingBadCharacters>> = characterDao.findallCharacters()


    suspend fun refreshCharacter(){
        withContext(Dispatchers.IO){
            val characters = BreakingBadNetwork.servies.getCharacters()

            characterDao.insertAllCharacters(characters)
        }
    }
}