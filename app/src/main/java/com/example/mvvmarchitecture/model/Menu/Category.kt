package com.example.mvvmarchitecture.model.Menu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("id")
    val id: String,
    @SerialName("menuItems")
    val menuItems: List<MenuItem>,
    @SerialName("name")
    val name: String
)