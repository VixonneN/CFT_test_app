package com.example.cfttestapp.models

import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @field:SerializedName("Valute")
    val currency: Map<String, CurrencyInfo>
    )