package com.example.olim_prototip.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.olim_prototip.R
import com.example.olim_prototip.databinding.ActivityMainBinding
import com.example.olim_prototip.presenter.MainPresenter

class MainActivity : AppCompatActivity() {
//    private var _binding: ActivityMainBinding? = null
//    private val binding: ActivityMainBinding get() = _binding!!
//    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        presenter= MainPresenter(this)
//        loadUi()
    }
//    private fun loadUi(){
//        presenter.addFragment()
//    }
    fun addFragment(){
//        supportFragmentManager.commit{
//            setReorderingAllowed(true)
//            add(binding.fragment.id, SplashScreen(),"Splash Screen")
//        }
    }
}