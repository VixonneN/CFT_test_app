package com.example.cfttestapp.models

import com.google.gson.annotations.SerializedName

data class CurrencyInfo(
    @SerializedName("ID")
    val id: String,
    @SerializedName("CharCode")
    val charCode: String,
    @SerializedName("Nominal")
    val nominal : Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Value")
    val value: Double,
    @SerializedName("Previous")
    val previous: Double
)
