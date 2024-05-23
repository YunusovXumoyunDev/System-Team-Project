package com.example.olim_prototip.presenter

import com.example.olim_prototip.screen.MainActivity

class MainPresenter(
    private val view: MainActivity
) {
    fun addFragment(){
        view.addFragment()
    }
}