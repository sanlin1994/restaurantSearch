package com.example.mvvmarchitecture.model.Menu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    @SerialName("categories")
    val categories: List<Category>,
    @SerialName("restaurantId")
    val restaurantId: Int
)