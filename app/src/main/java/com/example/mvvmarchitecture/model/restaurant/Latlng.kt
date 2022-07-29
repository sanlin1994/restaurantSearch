package com.example.mvvmarchitecture.model.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Latlng(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lng")
    val lng: Double
)