package com.example.randomquiz.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.randomquiz.component.Questions

//using viewmodel
@Composable
fun TriviaHome(viewmodel:QuestionsViewModel = hiltViewModel()){
    Questions(viewmodel)

}