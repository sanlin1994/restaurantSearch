package com.example.mvvmarchitecture.model.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Restaurants(
    @SerialName("restaurants")
    val restaurants: List<Restaurant>
)