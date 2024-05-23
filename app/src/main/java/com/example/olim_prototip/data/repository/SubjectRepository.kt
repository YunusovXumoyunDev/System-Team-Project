package com.example.olim_prototip.data.repository

import android.content.Context
import com.example.olim_prototip.R
import com.example.olim_prototip.data.model.SubjectData

val IT_ID=0
val MATH_ID=1
val FIZIK_ID=2
val CHEMISTRY_ID=3
val LANGUAGE_ID=4
val HISTORY_ID=5
class SubjectRepository(private val context: Context) {
    private var ls = ArrayList<SubjectData>()
    fun getSubject(): List<SubjectData> {
        return ls
    }

    fun getSubjectById(id: Int): SubjectData? {
        val data = ls.find { item ->
            item.id == id
        }
        return data
    }

    init {
        loadList()
    }

    fun loadList() {
        addPerson(
            SubjectData(
                id = IT_ID,
                name = "It Savodxonlik",
                image = R.drawable.bg_it,
                description = R.string.it_description
            )
        )
        addPerson(
            SubjectData(
                id = MATH_ID,
                name = "Mathematics",
                image = R.drawable.bg_math,
                description = 1
            )
        )
        addPerson(
            SubjectData(
                id = FIZIK_ID,
                name = "Fzika",
                image = R.drawable.bg_phisy,
                description = 1
            )
        )
        addPerson(
            SubjectData(
                id = CHEMISTRY_ID,
                name = "Kimyo",
                image = R.drawable.bg_chemis,
                description = 1
            )
        )
        addPerson(
            SubjectData(
                id = LANGUAGE_ID,
                name = "Tilshunoslik",
                image = R.drawable.bg_lang,
                description = 1
            )
        )
        addPerson(
            SubjectData(
                id = HISTORY_ID,
                name = "Tarix",
                image = R.drawable.bg_lit,
                description = 1
            )
        )
    }

    private fun addPerson(data: SubjectData) {
        ls.add(data)
    }
}