package com.example.olim_prototip.presenter

import com.example.olim_prototip.data.model.SubjectData
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.data.repository.CHEMISTRY_ID
import com.example.olim_prototip.data.repository.FIZIK_ID
import com.example.olim_prototip.data.repository.HISTORY_ID
import com.example.olim_prototip.data.repository.IT_ID
import com.example.olim_prototip.data.repository.LANGUAGE_ID
import com.example.olim_prototip.data.repository.MATH_ID
import com.example.olim_prototip.data.repository.QuestRepo
import com.example.olim_prototip.data.repository.SubjectRepository
import com.example.olim_prototip.screen.MainScreen

class MainScreenPresenter(
    private val view: MainScreen,
    private val repository: SubjectRepository,
    private val questRepo: QuestRepo,
    private val authRepository: AuthRepository
) {
    private val ls: List<SubjectData> = repository.getSubject()

    init {
        loadUi()
    }

    private fun loadUi() {
        ls.getOrNull(0)?.let {
            view.setFirstItemDetail(it)
        }

        ls.getOrNull(1)?.let {
            view.setSecondItemDetail(it)
        }
        ls.getOrNull(2)?.let {
            view.setThirdItemDetail(it)
        }
        ls.getOrNull(3)?.let {
            view.setFourthItemDetail(it)
        }
        ls.getOrNull(4)?.let {
            view.setFifthItemDetail(it)
        }
        ls.getOrNull(5)?.let {
            view.setSixthItemDetail(it)
        }
        view.setUserName(authRepository.getName())
        view.setPhone(authRepository.getNumber())

    }

    fun sumScore() {
        val sum = questRepo.getAllQuestRepo().sumOf {
            if (it.isDone)
                it.score
            else 0
        }
        view.showScore(sum)
    }

    fun clickFirstItem() {
        view.openDetailScreen(IT_ID)
    }

    fun clickSecondItem() {
        view.openDetailScreen(MATH_ID)
    }

    fun clickThirdItem() {
        view.openDetailScreen(FIZIK_ID)
    }

    fun clickFourthItem() {
        view.openDetailScreen(CHEMISTRY_ID)
    }
    fun clickFifthItem() {
        view.openDetailScreen(LANGUAGE_ID)
    }

    fun clickSixthItem() {
        view.openDetailScreen(HISTORY_ID)
    }

}