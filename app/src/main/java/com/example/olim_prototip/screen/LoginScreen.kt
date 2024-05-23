package com.example.olim_prototip.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.databinding.ScreenLoginBinding
import com.example.olim_prototip.presenter.LoginPresenter

class LoginScreen : Fragment(R.layout.screen_login) {
    private var _binding: ScreenLoginBinding? = null
    private val binding: ScreenLoginBinding get() = _binding!!
    private lateinit var presenter: LoginPresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenLoginBinding.bind(view)
        repository = AuthRepository(requireContext())
        presenter = LoginPresenter(this, repository)
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.register.setOnClickListener {
            presenter.registerClick()
        }
        binding.button.setOnClickListener {
            presenter.signInClick()
        }
        binding.forgetPassword.setOnClickListener {
            presenter.forgetClick()
        }

    }

    fun registerClick() {
        findNavController().navigate(R.id.action_loginScreen_to_createScreen)

    }
    fun forgetClick(){
        findNavController().navigate(R.id.action_loginScreen_to_forgetPasswordScreen)
    }
    fun showForgetPassword(){
        binding.forgetPassword.isVisible=true
    }
    fun hideRegister(){
        binding.registerLy.isVisible=false
    }
    fun hideForgetPassword(){
        binding.forgetPassword.isVisible=false
    }
    fun showRegister(){
        binding.registerLy.isVisible=true
    }

    fun getLogin(): String = binding.usernameEt.text.toString()
    fun getPassword(): String = binding.passwordEt.text.toString()
    fun signIn() {
        findNavController().navigate(R.id.action_loginScreen_to_mainScreen)

    }

    fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}