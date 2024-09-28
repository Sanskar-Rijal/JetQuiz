package com.example.randomquiz.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomquiz.data.DataorException
import com.example.randomquiz.model.Questions
import com.example.randomquiz.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor(private val Repository:QuestionRepository):ViewModel() {
    val data :MutableState<DataorException<ArrayList<Questions>,Boolean,Exception>>
    = mutableStateOf(DataorException(null,true,Exception(""))) //initally

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading=true
            data.value=Repository.getAllQuestion()
            if(data.value.toString().isNotEmpty()){
                data.value.loading=false //if its not empty we have something so setting it to false
            }
        }
    }
}