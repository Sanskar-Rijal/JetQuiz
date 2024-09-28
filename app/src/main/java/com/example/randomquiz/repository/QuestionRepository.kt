package com.example.randomquiz.repository
import android.util.Log
import com.example.randomquiz.data.DataorException
import com.example.randomquiz.model.Questions
import com.example.randomquiz.network.Question_Api
import javax.inject.Inject

//similar to taking data from Dao

class QuestionRepository @Inject constructor(
    private val api :Question_Api) {

    private val dataOrException =  //wrapping data in dataorException
        DataorException<ArrayList<Questions>,
            Boolean, //to check whether it's still loading or not
            Exception>() //to check whether there is issue or not

    suspend fun getAllQuestion():DataorException<ArrayList<Questions>,Boolean,Exception>{
        try {
            dataOrException.loading=true //it's loading
            dataOrException.data=api.getAllQuestion()
            if(dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading=false //means we got something so no need to load
            }
        }
        catch (exception:Exception){
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestion: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}