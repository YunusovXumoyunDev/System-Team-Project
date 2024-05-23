package com.example.olim_prototip.presenter

import com.example.olim_prototip.screen.CreateScreen
import com.example.olim_prototip.data.repository.AuthRepository
import com.example.olim_prototip.data.utils.checkLogin
import com.example.olim_prototip.data.utils.checkPassword

class CreatePresenter (
    private val view: CreateScreen,
    private val repository: AuthRepository
) {
    init {

    }

    fun create() {
        val name = view.getName()
        val login = view.getLogin()
        val password = view.getPassword()
        val phone = view.getPhone()
        val email = view.getEmail()
        if (login.checkLogin() && password.checkPassword()) {

                repository.create(
                    name = name,
                    login = login,
                    password = password,
                    phone = phone,
                    email = email,
                )
                view.success()
                repository.createUser()
        } else {
            view.showError()
        }
    }
}