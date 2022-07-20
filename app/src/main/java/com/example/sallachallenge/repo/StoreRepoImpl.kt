package com.example.sallachallenge.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.sallachallenge.model.BaseStoreData
import com.example.sallachallenge.paging.StorePagingSource
import com.example.sallachallenge.retrofit.StoreApi
import javax.inject.Inject

class StoreRepoImpl @Inject constructor(private val storeApi: StoreApi): StoreRepo {
    override fun getStoreData() = Pager(
        config = PagingConfig(pageSize = 5, maxSize = 20, enablePlaceholders = false),
        pagingSourceFactory = {StorePagingSource(storeApi)}
    ).liveData

            /*BaseStoreData{
        return storeApi.getStoreData()
    }*/


}