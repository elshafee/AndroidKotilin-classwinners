package com.elshafee.androidclasswin.breakingbadapi.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elshafee.androidclasswin.breakingbadapi.model.BreakingBadCharacters
@Dao
interface CharacterDao {
    @Query("SELECT * FROM character ")
    fun findallCharacters():LiveData<List<BreakingBadCharacters>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCharacters(characterList:List<BreakingBadCharacters>)
}