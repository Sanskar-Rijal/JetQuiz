package com.example.randomquiz.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomquiz.screens.QuestionsViewModel
import com.example.randomquiz.util.AppColors

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


@Preview
@Composable
fun QuestionDisplay(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(4.dp),
        color=AppColors.mDarkPurple) {
        Column(modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start){
            QuestionTracker()

        }
    }
}


@Preview
@Composable
fun QuestionTracker(counter:Int=10,outofInt:Int=100){

    //Annoated string helps us to make text of different size
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)){
        withStyle(style = SpanStyle(color = AppColors.mLightGray,
            fontWeight = FontWeight.Bold,
            fontSize = 27.sp)){
            
            append("Question $counter/")
            withStyle(style = SpanStyle(color = AppColors.mLightGray,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp)){
                append("$outofInt")
            }
        }
    }
}, modifier = Modifier
        .padding(25.dp))
}