package com.elshafee.androidclasswin.breakingbadapi

import android.app.Application
import com.elshafee.androidclasswin.breakingbadapi.db.CharacterDatabase
import com.elshafee.androidclasswin.breakingbadapi.repositry.CharacterRepositry

class BreakingBadApllication :Application(){
    val database by lazy {
        CharacterDatabase.createDatabase(this)
    }
    val characterRepository by lazy {
        CharacterRepositry(database.createCharacterDao())
    }
}