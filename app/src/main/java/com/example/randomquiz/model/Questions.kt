package com.example.randomquiz.model

data class Questions(
    val answer:String,
    val category: String,
    val choices:List<String>,
    val question: String
)