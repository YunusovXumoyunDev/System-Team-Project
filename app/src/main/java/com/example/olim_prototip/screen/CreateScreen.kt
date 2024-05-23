package com.example.olim_prototip.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.databinding.ScreenCreateBinding
import com.example.olim_prototip.presenter.CreatePresenter

class CreateScreen : Fragment(R.layout.screen_create) {

    private var _binding: ScreenCreateBinding? = null
    private val binding: ScreenCreateBinding get() = _binding!!
    private lateinit var presenter: CreatePresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenCreateBinding.bind(view)
        repository = AuthRepository(requireContext())
        presenter = CreatePresenter(this, repository)
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.button.setOnClickListener {
            presenter.create()
        }
    }

    fun getLogin(): String = binding.usernameEt.text.toString()
    fun getPassword(): String = binding.passwordEt.text.toString()
    fun getName(): String = binding.nameEt.text.toString()
    fun getEmail(): String = binding.mailEt.text.toString()
    fun getPhone(): String = binding.phoneEt.text.toString()

    fun success() {
        findNavController().navigateUp()
    }

    fun showError(){
        Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show()
    }
}