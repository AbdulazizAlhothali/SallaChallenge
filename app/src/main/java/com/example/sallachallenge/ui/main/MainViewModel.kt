package com.example.sallachallenge.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.sallachallenge.model.BaseStoreData
import com.example.sallachallenge.repo.StoreRepo
import com.example.sallachallenge.repo.StoreRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: StoreRepo) : ViewModel()  {
    val list = repo.getStoreData().cachedIn(viewModelScope)
    /*fun getData(): LiveData<BaseStoreData>{
        val animes = MutableLiveData<BaseStoreData>()
        viewModelScope.launch {
            try {
                animes.postValue(repo.getStoreData())
            } catch (e: Throwable ){
                Log.e("Store", "Data Problem : ${e.localizedMessage}")
            }
        }
        return animes
    }*/
}