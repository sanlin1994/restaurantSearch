package com.example.mvvmarchitecture.model.Menu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Menus(
    @SerialName("menus")
    val menus: List<Menu>
)