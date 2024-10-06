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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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

    }
    else{
        if (questions != null){
            QuestionDisplay(question=questions.first())
        }
    }

}



@Composable
fun QuestionDisplay(
    question:Questions,
   // questionIndex:MutableState<Int>,
    //viewmodel:QuestionsViewModel,
    onNextClicked:(Int)->Unit ={ }
){
    //Stores the list of answer choices for the current question.
    /**
     * question is used as a key in remember, so when the question object changes,
     */
    val choices = remember(question) {
        question.choices.toMutableList() //when question object will change then  screen will remember the state
    }

        //Tracks the index of the currently selected answer.
    val answerstate = remember(question) {
        mutableStateOf<Int?>(null)
    }

    // Indicates whether the selected answer is correct.
    val correctAnswerState = remember(question) {
        mutableStateOf<Boolean?>(null)
    }

    //  Handles the logic when a user selects an answer.
    val updateAnswer : (Int) -> Unit = remember(question) {
        {it
            //it  is integer that is controlling index for correct choices
            answerstate.value= it
            correctAnswerState.value = choices[it] == question.answer
        }
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
                Text(text = question.questions,
                    modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.Start)
                        .fillMaxHeight(0.3f),//0.3f means we want 30% height of the entire screen
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp,
                    color = AppColors.mOffWhite)


            //choices foreachIndexed is a for loop which will run for each index
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
                                AppColors.mDarkPurple)), shape = RoundedCornerShape(15.dp)),
                        verticalAlignment = Alignment.CenterVertically){

                        //Determines if the current RadioButton is selected based on answerstate.
                        /**
                         * example
                         * index = 0, answerText = "Option A"
                         * index = 1, answerText = "Option B"
                         * index = 2, answerText = "Option C"
                         * index = 3, answerText = "Option D"
                         *
                         * In each loop, index represents the position of the current answer
                         * choice in the list, so if you select "Option B", the index for that choice is 1.
                         */

                        RadioButton(selected =(answerstate.value == index), onClick = {
                            updateAnswer(index)
                        }, modifier = Modifier.padding(start = 16.dp),
                            colors = RadioButtonDefaults.colors(
                                selectedColor =
                                    if(correctAnswerState.value == true
                                        && index == answerstate.value){
                                        Color.Green.copy(alpha = 0.3f)
                                    }
                                    else{
                                        Color.Red.copy(alpha = 0.3f)
                                    })) //end of radio button
                        Text(text = answerText)
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