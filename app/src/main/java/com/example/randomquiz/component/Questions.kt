package com.example.randomquiz.component

import android.graphics.PathEffect
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomquiz.model.Questions
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
fun QuestionDisplay(
    question:Questions,
    questionIndex:MutableState<Int>,
    viewmodel:QuestionsViewModel,
    onNextClicked:(Int)->Unit
){

    //makking states for buttons
    val choices = remember(question) {
        question.choices.toMutableList() //when question objec twill change then  screen will remember the state
    }


    val pathEffect =androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        color=AppColors.mDarkPurple) {
        Column(modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start){
            QuestionTracker()
            DrawComposable(pathEffect)
            Column(){
                Text(text = "What is the Meaning of This",
                    modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.Start)
                        .fillMaxHeight(0.3f),//0.3f means we want 30% height of the entire screen
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                    color = AppColors.mOffWhite)


            //choices
                choices.forEachIndexed{index,answerText->
                    Row(modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .clip(RoundedCornerShape(topStart = CornerSize(50), topEnd = CornerSize(50),
                            bottomEnd = CornerSize(50), bottomStart = CornerSize(50)))
                        .background(Color.Transparent)
                        .border(width = 4.dp, brush = Brush.linearGradient(
                            colors = listOf(AppColors.mDarkPurple,
                                AppColors.mDarkPurple)), shape = RoundedCornerShape(15.dp))){

                    }
                }
            }

        }
    }
}

//dotted line
@Composable
fun DrawComposable(patheffect:androidx.compose.ui.graphics.PathEffect ){
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.5.dp)) {
        drawLine(color = AppColors.mLightGray,
            start = Offset(0f,0f),// x and y direction we are not moving so 0f
            end = Offset(size.width,0f),
            pathEffect = patheffect
        )
    }
}



//question tracker Question 10/4299
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