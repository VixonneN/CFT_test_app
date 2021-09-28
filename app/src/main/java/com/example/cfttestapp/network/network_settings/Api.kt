package com.example.cfttestapp.network.network_settings

import androidx.lifecycle.LiveData
import com.example.cfttestapp.models.Time
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("daily_json.js")
    fun getCurrency() : Call<Time>
}