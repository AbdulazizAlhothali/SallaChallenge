package com.example.sallachallenge.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sallachallenge.models.details.DetailsBase
import com.example.sallachallenge.repo.StoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repo: StoreRepo)  : ViewModel() {
    fun getDetailsData(header: String, productId: String): LiveData<DetailsBase> {
        val details = MutableLiveData<DetailsBase>()
        viewModelScope.launch {
            try {
                details.postValue(repo.getDetailsData(header, productId))
            } catch (e: Throwable ){
                Log.e("Store", "Problem : ${e.localizedMessage}")
            }
        }
        return details
    }
}