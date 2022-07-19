package com.example.homwork11

import androidx.annotation.DrawableRes

data class ItemData(
    val firstName: String,
    val lastname: String,
    @DrawableRes
    val image: Int,
    val trashImage: Int
)
