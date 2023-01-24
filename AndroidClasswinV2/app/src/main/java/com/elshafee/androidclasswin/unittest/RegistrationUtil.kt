package com.elshafee.androidclasswin.unittest

object RegistrationUtil {
    private val existingUsers = listOf("Said", "Laila")

    fun validateRegistrationInput(
        username:String,
        passsword:String,
        confirmationPassword:String,
    ):Boolean{

        if (username.isEmpty() || passsword.isEmpty()){
            return false
        }
        if(username in existingUsers){
            return false
        }
        if(passsword != confirmationPassword){
            return false
        }
        if (passsword.count{it.isDigit()}<2){
            return false
        }
        return true

    }


}