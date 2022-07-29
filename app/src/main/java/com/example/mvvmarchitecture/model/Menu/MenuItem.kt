package com.example.mvvmarchitecture.model.Menu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<String?>,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: String
)

