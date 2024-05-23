package com.example.olim_prototip.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.olim_prototip.R
import com.example.olim_prototip.data.storage.local.LocalStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen:Fragment(R.layout.splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val storadge=LocalStorage(requireContext())
        lifecycleScope.launch {
            delay(500)
            if (storadge.getBoolean("isUserEnteredBefore")){
                findNavController().navigate(R.id.action_splashScreen_to_mainScreen)
            }else{
                findNavController().navigate(R.id.action_splashScreen_to_loginScreen)

            }
        }
    }
}