package com.example.randomquiz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.randomquiz.screens.QuestionsViewModel
import com.example.randomquiz.screens.TriviaHome
import com.example.randomquiz.ui.theme.RandomQuizTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //so that hilt knows mainactivity will be getting access to all of those
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            myapp {
                TriviaHome()

            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    RandomQuizTheme {
//        Greeting("Android")
//    }
//}


@Composable
fun myapp(content:@Composable () -> Unit){
    RandomQuizTheme {
        content()
    }
}
