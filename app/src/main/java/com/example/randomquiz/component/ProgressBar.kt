package com.example.randomquiz.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomquiz.util.AppColors

//composable for showing progress bar
@Preview
@Composable
fun ShowProgress(Score:Int=100){
    //creating color for progess bar

    //state for progress bar
    val progressState = remember(Score) {
        mutableStateOf(Score*0.005f)
    }
    val gradient = Brush.linearGradient(colors = listOf(
        Color(0xFFF95075)
        , Color(0xFFBE6BE5)
    ))
    Row(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .height(45.dp)
        .border(width = 4.dp,
            brush = Brush.linearGradient(colors = listOf(
                AppColors.mLightPurple,
                AppColors.mLightPurple
            )), shape = RoundedCornerShape(34.dp)
        )
        .clip(
            RoundedCornerShape(topStart = CornerSize(50), bottomStart = CornerSize(50),
            topEnd = CornerSize(50), bottomEnd = CornerSize(50)
            )
        )
        .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(contentPadding = PaddingValues(1.dp),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(progressState.value)//if you use progressState by remember... then you don't have to use .value
                .background(brush = gradient),
            enabled = false,//we don't want it to be clickable
            elevation = null,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent)
        ) {
//            Text(text = (Score*10).toString(),
//                modifier = Modifier.clip(shape = RoundedCornerShape(25.dp))
//                    .fillMaxHeight(0.87f)
//                    .fillMaxWidth()
//                    .padding(5.dp),
//                color = AppColors.mOffWhite,
//                textAlign = TextAlign.Center
//            )
        }
    }
}