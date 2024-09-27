package com.example.randomquiz.repository
import com.example.randomquiz.data.DataorException
import com.example.randomquiz.model.Questions
import com.example.randomquiz.network.Question_Api
import javax.inject.Inject


class QuestionRepository @Inject constructor(
    private val api :Question_Api) {

    private val listofQuestions =  //wrapping data in dataorException
        DataorException<ArrayList<Questions>,
            Boolean, //to check whether it's still loading or not
            Exception>() //to check whether there is issue or not
}