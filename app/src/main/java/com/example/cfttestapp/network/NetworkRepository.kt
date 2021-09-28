package com.example.cfttestapp.network

import com.example.cfttestapp.network.network_settings.NetworkModule

class NetworkRepository constructor(private val networkModule: NetworkModule) {

    fun getCurrency() = networkModule.api().getCurrency()

}