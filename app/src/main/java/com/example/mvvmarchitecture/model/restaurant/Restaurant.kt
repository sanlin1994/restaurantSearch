package com.example.mvvmarchitecture.model.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    @SerialName("address")
    val address: String,
    @SerialName("cuisine_type")
    val cuisine_type: String,
    @SerialName("id")
    val id: Int,
    @SerialName("latlng")
    val latlng: Latlng,
    @SerialName("name")
    val name: String,
    @SerialName("neighborhood")
    val neighborhood: String,
    @SerialName("operating_hours")
    val operating_hours: OperatingHours,
    @SerialName("photograph")
    val photograph: String,
    @SerialName("reviews")
    val reviews: List<Review>
)