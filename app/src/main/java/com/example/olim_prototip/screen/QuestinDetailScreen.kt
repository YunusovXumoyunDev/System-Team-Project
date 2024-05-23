package com.example.olim_prototip.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.repository.QuestRepo
import com.example.olim_prototip.databinding.ItemDescriptionBinding

class QuestinDetailScreen: Fragment(R.layout.item_description) {
    private lateinit var bindign: ItemDescriptionBinding
    lateinit var repository: QuestRepo
    private var questId=-1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindign= ItemDescriptionBinding.bind(view)
        repository= QuestRepo(requireContext())
        loadUi()
        laodUiClickable()
    }
    fun loadUi(){
        questId=requireArguments().getInt("quest_id",-1)
        val quest=repository.getQuestByID(questId)
        bindign.title.text=quest?.title?:""
        bindign.text.text=quest?.text?.let { requireContext().getString(quest.text) }?:""
        if (quest?.isDone==true){
            bindign.checkbox.isChecked=true
        }
    }
    fun laodUiClickable(){
        bindign.tb.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        bindign.checkbox.setOnCheckedChangeListener{view,isChecked->
            if (isChecked){
                repository.addNewQuestDone(questId)
            }else{
                repository.remove(questId)
            }

        }
    }
}