package com.example.sallachallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sallachallenge.models.developersjson.DevelopersJson

class SharedViewModel: ViewModel() {
    val jsonDev = MutableLiveData<DevelopersJson>()

    fun jsonDevValue(json: DevelopersJson) {
        jsonDev.value = json
    }
}