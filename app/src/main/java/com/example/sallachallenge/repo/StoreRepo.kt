package com.example.sallachallenge.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.sallachallenge.model.BaseStoreData
import com.example.sallachallenge.model.Data

interface StoreRepo {
    fun getStoreData(): /*BaseStoreData*/LiveData<PagingData<Data>>
}