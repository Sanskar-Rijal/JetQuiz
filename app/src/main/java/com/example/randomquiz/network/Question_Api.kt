package com.example.randomquiz.network

import com.example.randomquiz.model.AllQuestions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface Question_Api {
    @GET("world.json")
    suspend fun getAllQuestion():AllQuestions
}