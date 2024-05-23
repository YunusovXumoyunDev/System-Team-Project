package com.example.olim_prototip.data.model

import androidx.annotation.DrawableRes

data class SubjectData(
    val id: Int,
    val name: String,
    @DrawableRes
    val image: Int,
    val description: Int
)
