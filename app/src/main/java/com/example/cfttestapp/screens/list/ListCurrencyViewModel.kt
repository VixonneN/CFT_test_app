package com.example.cfttestapp.screens.list

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cfttestapp.models.CurrencyInfo
import com.example.cfttestapp.models.Time
import com.example.cfttestapp.network.NetworkRepository
import com.example.cfttestapp.network.network_settings.NetworkModule
import com.example.cfttestapp.utilits.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCurrencyViewModel(application: Application): AndroidViewModel(application) {

    var currencyList = MutableLiveData<Time>()

    fun getCurrency() {

        val repository = NetworkRepository(networkModule = NetworkModule())
        repository.getCurrency().enqueue(object : Callback<Time> {
            override fun onResponse(call: Call<Time>, response: Response<Time>) {
                currencyList.value = response.body()
            }

            override fun onFailure(call: Call<Time>, t: Throwable) {
                showToast(t.message!!)
            }
        })
    }

    //map to string
    fun getDataToList(map: Map<String, CurrencyInfo>): MutableList<CurrencyInfo> {
        return map.values.toMutableList()
    }
}