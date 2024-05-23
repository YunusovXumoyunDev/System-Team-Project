package com.example.olim_prototip.screen

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.databinding.ScreenForgetPasswordBinding
import com.example.olim_prototip.presenter.ForgetPresenter

class ForgetPasswordScreen : Fragment(R.layout.screen_forget_password) {
    private var _binding: ScreenForgetPasswordBinding? = null
    private val binding: ScreenForgetPasswordBinding get() = _binding!!
    private lateinit var repository: AuthRepository
    private lateinit var presenter: ForgetPresenter
    private val time = 120
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenForgetPasswordBinding.bind(view)
        repository = AuthRepository(requireContext())
        presenter = ForgetPresenter(this, repository)
        startLoadUi()
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.sendLoginBtn.setOnClickListener {
            presenter.sendLoginClick()
        }
        binding.sendCodeBtn.setOnClickListener {
            presenter.sendCodeClick()
        }
        binding.enterBtn.setOnClickListener {
            presenter.enterClick()
        }
        binding.back.setOnClickListener {
            presenter.backClick()
        }
    }

    fun startTimer() {
        generateCode()
        val timer = object : CountDownTimer(time * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                presenter.loadTimer(millisUntilFinished / 1000)
            }

            override fun onFinish() {
                presenter.code = -1
                resendVisibility()
            }
        }
        timer.start()
    }

    private fun startLoadUi() {
        binding.loginEtLy.isVisible = true
        binding.sendLoginBtn.isVisible = true
    }

    private fun txtChange(txt: String) {
        binding.txtLogin.text = txt
    }

    fun setTimer(timer: String) {
        binding.timer.text = timer
    }

    fun hideLogin() {
        binding.loginEtLy.isVisible = false
        binding.sendLoginBtn.isVisible = false
    }

    fun showCode() {
        val phone = repository.getNumber()
        txtChange("Ushbu $phone raqamga jo'natilgan SMS kodni kiriting")
        binding.codeEtLy.isVisible = true
        binding.codeTxt.isVisible = true
        binding.code.isVisible = true
        binding.sendCodeBtn.isVisible = true
        binding.timer.isVisible = true
    }

    fun hideCode() {
        binding.codeEtLy.isVisible = false
        binding.codeTxt.isVisible = false
        binding.code.isVisible = false
        binding.sendCodeBtn.isVisible = false
        binding.timer.isVisible = false
    }

    fun showPassword() {
        txtChange("Yangi parolni kiriting")
        binding.newPasswordEtLy.isVisible = true
        binding.confirmNewPasswordEtLy.isVisible = true
        binding.enterBtn.isVisible = true
    }

    fun getLogin(): String = binding.loginEt.text.toString()
    fun getCode(): String = binding.codeEt.text.toString()
    fun getPassword(): String = binding.newPasswordEt.text.toString()
    fun getConfirmPassword(): String = binding.confirmNewPasswordEt.text.toString()
    fun enterClick() {
        findNavController().popBackStack()
    }

    fun backClick() {
        findNavController().popBackStack()
    }

    fun resendVisibility() {
        binding.resendTxt.isVisible = true
    }

    fun generateCode() {
        binding.code.text = presenter.generateCode().toString()
    }

    fun error(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }
}