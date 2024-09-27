package com.example.randomquiz.di

import com.example.randomquiz.model.Questions
import com.example.randomquiz.network.Question_Api
import com.example.randomquiz.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module //adding it because it's dagger or hilt module
@InstallIn(SingletonComponent::class) //it means we want this to be created only once
object AppModule {

    @Singleton //we don't want repetation or instances of this class
    @Provides //it will provide something so @Provides
    fun provideQuestionApi():Question_Api{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)//passing base url from Constants
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Question_Api::class.java)
    }
}