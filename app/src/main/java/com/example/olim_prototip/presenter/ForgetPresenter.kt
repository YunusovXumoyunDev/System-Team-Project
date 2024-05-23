package com.example.olim_prototip.presenter

import com.example.olim_prototip.screen.ForgetPasswordScreen
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.data.utils.checkPassword
import kotlin.random.Random

class ForgetPresenter(
    private val view: ForgetPasswordScreen,
    private val repository: AuthRepository
) {
    var code = -1

    fun loadTimer(timer: Long): String {
        val min = timer / 60
        val second = timer % 60
        val minText = if (min < 10) "0$min" else min.toString()
        val secondText = if (second < 10) "0$second" else second.toString()
        view.setTimer("$minText:$secondText")
        return "$minText:$secondText"
    }

    fun backClick(){
        view.backClick()
    }
    fun enterClick() {
        val password = view.getPassword()
        val confirmPassword = view.getConfirmPassword()
        if (password.checkPassword()) {
            if (password == confirmPassword) {
                repository.create(
                    login = repository.getLogin(),
                    name = repository.getName(),
                    email = repository.getEmail(),
                    phone = repository.getNumber(),
                    password = password
                )
            } else {
                view.error("Password va ConfirmPassword bir xil emas!")
            }
            view.enterClick()
        } else {
            view.error("Parol to'g'ri kiritilmagan")
        }
    }

    fun sendLoginClick() {
        if (view.getLogin() == repository.getLogin()) {
            view.hideLogin()
            view.showCode()
            view.startTimer()
        } else {
            view.error("Siz kiritgan login ro'yxatdan o'tmagan!")
        }
    }

    fun sendCodeClick() {
        if (view.getCode().toInt()==code ) {
            view.hideCode()
            view.showPassword()
        } else {
            view.error("Kiritilgan kod xato!")
        }
    }

    fun generateCode(): Int {
        code = Random.nextInt(1000, 10000)
        return code
    }

}