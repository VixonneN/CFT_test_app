package com.example.cfttestapp.network.network_settings

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    private val api: Api
    fun api(): Api {
        return api
    }

    init {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(loggingInterceptor)
        val retrofit: Retrofit = Retrofit.Builder()
            .client(builder.build())
            .baseUrl("https://www.cbr-xml-daily.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
    }

}