package com.elshafee.androidclasswin.breakingbadapi.services

import com.elshafee.androidclasswin.breakingbadapi.model.BreakingBadCharacters
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://63c4417ba908563575346178.mockapi.io/api/v1/"
interface BrekingBadServies {
@GET("characters")
suspend fun getCharacters():List<BreakingBadCharacters>

}

object BreakingBadNetwork{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val servies = retrofit.create(BrekingBadServies::class.java)
}