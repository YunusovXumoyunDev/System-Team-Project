package com.example.olim_prototip.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.olim_prototip.R
import com.example.olim_prototip.adapter.MyRecyclerAdapter
import com.example.olim_prototip.data.repository.QuestRepo
import com.example.olim_prototip.databinding.ItQuestionsScreenBinding

class QuestinListScreen:Fragment(R.layout.it_questions_screen) {
    private lateinit var bindign:ItQuestionsScreenBinding
    private val adapter=MyRecyclerAdapter()
    lateinit var repository:QuestRepo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindign=ItQuestionsScreenBinding.bind(view)
        repository= QuestRepo(requireContext())
        Log.d("TagTagTag","Onview created")

        loadUi()
        laodUiClickable()
    }
    fun loadUi(){
        val subjectID=requireArguments().getInt("subject_id",-1)

        val ls=repository.getAllWithSubjectIdQuestRepo(subjectID)

        adapter.list.clear()
        adapter.list.addAll(ls)
        bindign.rv.layoutManager=LinearLayoutManager(requireContext())
        bindign.rv.adapter=adapter
        adapter.notifyDataSetChanged()
    }
    fun laodUiClickable(){

        bindign.tb.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        adapter.itemClick={questId->
            findNavController().navigate(R.id.action_questinListScreen_to_questinDetailScreen, bundleOf(
                "quest_id" to questId
            ))
        }
    }
}