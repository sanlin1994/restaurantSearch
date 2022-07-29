package com.example.mvvmarchitecture.model.restaurant

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OperatingHours(
    @SerialName("Friday")
    val Friday: String,
    @SerialName("Monday")
    val Monday: String,
    @SerialName("Saturday")
    val Saturday: String,
    @SerialName("Sunday")
    val Sunday: String,
    @SerialName("Thursday")
    val Thursday: String,
    @SerialName("Tuesday")
    val Tuesday: String,
    @SerialName("Wednesday")
    val Wednesday: String
)