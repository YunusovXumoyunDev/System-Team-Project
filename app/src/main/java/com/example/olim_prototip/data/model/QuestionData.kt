package com.example.olim_prototip.data.model

data class QuestionData(
    val id :Int,
    val subjectID:Int,
    val text:String,
    val isDone:Boolean,
    val score:Int
)
