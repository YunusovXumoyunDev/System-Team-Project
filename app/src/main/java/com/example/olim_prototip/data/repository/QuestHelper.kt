package com.example.olim_prototip.data.repository

import com.example.olim_prototip.R
import com.example.olim_prototip.data.model.QuestDetailsData
import com.example.olim_prototip.data.model.QuestionData
import com.example.olim_prototip.data.model.toQuestData

class QuestHelper {
    private val quests = ArrayList<QuestDetailsData>()

    init {
        quests.add(
            QuestDetailsData(
                id = quests.size,
                subjectId = IT_ID,
                title = "It olam",
                text = R.string.it_description,
                isDone = false,
                questScore = 10
            )
        )
        quests.add(
            QuestDetailsData(
                id = quests.size,
                subjectId = MATH_ID,
                title = "Matematikaga kirish",
                text = R.string.math_description,
                isDone = false,
                questScore = 20
            )
        )
        quests.add(
            QuestDetailsData(
                id = quests.size,
                subjectId = FIZIK_ID,
                title = "Fizika tabiat haqidagi fan",
                text = R.string.physics_description,
                isDone = false,
                questScore = 15
            )
        )
        quests.add(
            QuestDetailsData(
                id = quests.size,
                subjectId = CHEMISTRY_ID,
                title = "Kimyo fani bu...",
                text = R.string.chemistry_description,
                isDone = false,
                questScore = 15
            )
        )
    }

    fun getAllSubjectQuestData(subjectID: Int): List<QuestionData> {
        return quests.filter {
            it.subjectId == subjectID
        }.map {
            it.toQuestData()
        }
    }
    fun getAllQuestData(): List<QuestionData> {
        return quests.map {
            it.toQuestData()
        }
    }
    fun getQuestionDetails(questId: Int): QuestDetailsData? {
        return quests.firstOrNull {
            it.subjectId == questId
        }
    }
}