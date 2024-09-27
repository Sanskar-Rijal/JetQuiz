package com.example.randomquiz.data

//just like using templates in c++ T data , data can be int ,float etc same case here
data class DataorException<T,Boolean,E:Exception>(
    var data:T?=null,
    var loading:Boolean?=null,
    var e:E?=null
)