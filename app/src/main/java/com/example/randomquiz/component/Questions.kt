package com.example.randomquiz.component

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.example.randomquiz.screens.QuestionsViewModel

@Composable
fun Questions(viewmodel: QuestionsViewModel){

    val questions = viewmodel.data.value.data?.toMutableList()
    if(viewmodel.data.value.loading==true){
        CircularProgressIndicator()
        Log.d("Loading", "Questions: Loading...")
    }
    else{
        questions?.forEach{questionitem->
            Log.d("result", "Questions: ${questionitem.questions}")

        }
    }

     Log.d("Size", "Questions: ${questions?.size}")
}