package com.example.cfttestapp.repository

import androidx.lifecycle.LiveData
import com.example.cfttestapp.models.Time

interface Repository {

    val allCurrency: LiveData<Time>
    fun getCurrency()
}