package com.example.mvvmarchitecture.model.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    @SerialName("comments")
    val comments: String,
    @SerialName("date")
    val date: String,
    @SerialName("name")
    val name: String,
    @SerialName("rating")
    val rating: Int
)