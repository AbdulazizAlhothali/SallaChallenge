package com.example.sallachallenge.ui.main

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.sallachallenge.models.brand.BrandData
import com.example.sallachallenge.repo.StoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: StoreRepo) : ViewModel()  {


    fun getItemData(header: String) = repo.getStoreData(header).cachedIn(viewModelScope)

    fun getBrandData(header: String): LiveData<BrandData>{
        val brand = MutableLiveData<BrandData>()
        viewModelScope.launch {
            try {
                brand.postValue(repo.getBrandData(header))
            } catch (e: Throwable ){
                Log.e("Store", "Problem : ${e.localizedMessage}")
            }
        }
        return brand
    }

}