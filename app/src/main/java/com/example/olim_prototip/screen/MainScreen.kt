package com.example.olim_prototip.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.model.SubjectData
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.data.repository.QuestRepo
import com.example.olim_prototip.data.repository.SubjectRepository
import com.example.olim_prototip.databinding.ScreenMainBinding
import com.example.olim_prototip.presenter.MainScreenPresenter

class MainScreen : Fragment(R.layout.screen_main) {
    private var _binding: ScreenMainBinding? = null
    private var headerDrawer: View? = null

    private val binding: ScreenMainBinding get() = _binding!!
    private lateinit var repository: SubjectRepository
    private lateinit var authRepository: AuthRepository
    private lateinit var presenter: MainScreenPresenter
    private lateinit var questRepo: QuestRepo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**
         * binding creating
         */
        _binding = ScreenMainBinding.bind(view)
        headerDrawer = binding.navViewHome.getHeaderView(0)
        /**
         * mvp details creating
         */
        repository = SubjectRepository(requireContext())
        authRepository = AuthRepository(requireContext())
        questRepo = QuestRepo(requireContext())
        presenter = MainScreenPresenter(
            view = this,
            repository = repository,
            authRepository = authRepository,
            questRepo = questRepo
        )
        /**
         * ui logic
         */
        presenter.sumScore()
        loadUiClickable()
    }

    fun setFirstItemDetail(data: SubjectData) {
        binding.firstItem.image.setBackgroundResource(data.image)
        binding.firstItem.name.text = data.name
    }

    fun setSecondItemDetail(data: SubjectData) {
        binding.secondItem.image.setBackgroundResource(data.image)
        binding.secondItem.name.text = data.name
    }

    fun setThirdItemDetail(data: SubjectData) {
        binding.thirdItem.image.setBackgroundResource(data.image)
        binding.thirdItem.name.text = data.name
    }

    fun setFourthItemDetail(data: SubjectData) {
        binding.fourthItem.image.setBackgroundResource(data.image)
        binding.fourthItem.name.text = data.name
    }
    fun setFifthItemDetail(data: SubjectData) {
        binding.fifthItem.image.setBackgroundResource(data.image)
        binding.fifthItem.name.text = data.name
    }
    fun setSixthItemDetail(data: SubjectData) {
        binding.sicthItem.image.setBackgroundResource(data.image)
        binding.sicthItem.name.text = data.name
    }


    fun openDetailScreen(subjectID:Int) {
        findNavController().navigate(
            R.id.action_mainScreen_to_questinListScreen, bundleOf(
                "subject_id" to subjectID
            )
        )
    }

    fun loadUiClickable() {
        binding.firstItem.root.setOnClickListener {
            presenter.clickFirstItem()
        }
        binding.secondItem.root.setOnClickListener {
            presenter.clickSecondItem()
        }
        binding.thirdItem.root.setOnClickListener {
            presenter.clickThirdItem()
        }
        binding.fourthItem.root.setOnClickListener {
            presenter.clickFourthItem()
        }
        binding.fifthItem.root.setOnClickListener {
            presenter.clickFifthItem()
        }
        binding.sicthItem.root.setOnClickListener {
            presenter.clickSixthItem()
        }
        binding.tb.setNavigationOnClickListener {
            binding.drawerLayoutHome.open()
        }
        headerDrawer?.findViewById<ImageView>(R.id.close_btn)?.setOnClickListener {
            binding.drawerLayoutHome.close()
        }
        binding.navViewHome.menu.findItem(R.id.home).setOnMenuItemClickListener {
            binding.drawerLayoutHome.close()
            true
        }
        binding.navViewHome.menu.findItem(R.id.setting).setOnMenuItemClickListener {
            binding.drawerLayoutHome.close()
            findNavController().navigate(R.id.action_mainScreen_to_settingScreen)
            true
        }
        binding.navViewHome.menu.findItem(R.id.help).setOnMenuItemClickListener {
            binding.drawerLayoutHome.close()
            findNavController().navigate(R.id.action_mainScreen_to_helpScreen)
            true
        }

    }

    fun setUserName(text: String) {
        headerDrawer?.findViewById<TextView>(R.id.name)?.let {
            it.text = text
        }
    }
    fun showScore(sumAll:Int){
        binding.score.text=sumAll.toString()
    }

    fun setPhone(text: String) {
        headerDrawer?.findViewById<TextView>(R.id.phone_number)?.let {
            it.text = "+998$text"
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        headerDrawer = null
    }
}