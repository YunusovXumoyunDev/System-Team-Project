package com.example.olim_prototip.data.repository

import android.content.Context
import com.example.olim_prototip.data.model.QuestDetailsData
import com.example.olim_prototip.data.model.QuestionData
import com.example.olim_prototip.data.storage.local.LocalStorage

class QuestRepo(private var context: Context) {
    private val localStorage = LocalStorage(context)
    private val questHelper = QuestHelper()

    fun getAllWithSubjectIdQuestRepo(subjectId: Int): List<QuestionData> {
        val ls = questHelper.getAllSubjectQuestData(subjectId)
        val doneLs = localStorage.getDoneList()
        return ls.map {
            if (doneLs.contains(it.id)) {
                it.copy(isDone = true)
            } else it
        }
    }
    fun getAllQuestRepo(): List<QuestionData> {
        val ls = questHelper.getAllQuestData()
        val doneLs = localStorage.getDoneList()
        return ls.map {
            if (doneLs.contains(it.id)) {
                it.copy(isDone = true)
            } else it
        }
    }

    fun addNewQuestDone(questID: Int) {
        val ls = ArrayList(localStorage.getDoneList())
        if (ls.contains(questID))
            return
        ls.add(questID)
        localStorage.saveDoneList(ls)
    }
    fun remove(questID: Int) {
        val ls = ArrayList(localStorage.getDoneList())
        ls.remove(questID)
        localStorage.saveDoneList(ls)
    }

    fun getQuestByID(questId: Int): QuestDetailsData? {
        val doneLs = localStorage.getDoneList()
        val data = questHelper.getQuestionDetails(questId)
        return if (doneLs.contains(questId)) {
            data?.copy(isDone = true)
        } else data
    }
}