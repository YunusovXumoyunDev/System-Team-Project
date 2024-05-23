package com.example.olim_prototip.presenter

import com.example.olim_prototip.screen.LoginScreen
import com.example.olim_prototip.data.repository.AuthRepository

class LoginPresenter(
    private val view: LoginScreen,
    private val repository: AuthRepository
) {

    init {
        if (repository.hasUser()){
            view.showForgetPassword()
            view.hideRegister()
        }else{
            view.hideForgetPassword()
            view.showRegister()
        }
    }
    fun registerClick() {
        view.registerClick()
    }
    fun forgetClick(){
        view.forgetClick()
    }
    fun signInClick(){
        if (checkLogin()&&checkPassword()){
            repository.userEntered()
            view.signIn()
        }else{
            view.showError("Login yoki parol xato")
        }
    }

    fun loadUi() {

    }

    private fun checkLogin():Boolean {
        val login = view.getLogin()
        return (login == (repository.getLogin())&&(login.isNotEmpty()))
    }

    private fun checkPassword():Boolean {
        val password = view.getPassword()
        return (password==(repository.getPassword())&&password.isNotEmpty())
    }
}