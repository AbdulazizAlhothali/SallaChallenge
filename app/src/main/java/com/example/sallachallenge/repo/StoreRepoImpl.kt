package com.example.sallachallenge.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.sallachallenge.paging.StorePagingSource
import com.example.sallachallenge.retrofit.StoreApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoreRepoImpl @Inject constructor(private val storeApi: StoreApi): StoreRepo {
    override fun getStoreData(header: String) = Pager(
        config = PagingConfig(pageSize = 2, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = {StorePagingSource(storeApi, header)}
    ).liveData

    override suspend fun getBrandData() = withContext(Dispatchers.IO){
        storeApi.getBrandeData()
    }

}