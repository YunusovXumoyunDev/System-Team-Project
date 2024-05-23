package com.example.olim_prototip.data.model

import androidx.annotation.StringRes

data class QuestDetailsData(
    val id:Int,
    val subjectId:Int,
    val title:String,
    val isDone:Boolean=false,
    @StringRes
    val text:Int,
    val questScore:Int
)

fun QuestDetailsData.toQuestData():QuestionData{
    return QuestionData(
        id = id,
        subjectID = subjectId,
        text = title,
        isDone = isDone,
        score = questScore
    )
}
