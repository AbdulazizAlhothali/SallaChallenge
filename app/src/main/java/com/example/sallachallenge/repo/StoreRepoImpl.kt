package com.example.sallachallenge.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.sallachallenge.models.details.DetailsBase
import com.example.sallachallenge.paging.StorePagingSource
import com.example.sallachallenge.retrofit.StoreApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoreRepoImpl @Inject constructor(private val storeApi: StoreApi): StoreRepo {
    override fun getStoreData(header: String) = Pager(
        config = PagingConfig(pageSize = 5, maxSize = 100, enablePlaceholders = false, initialLoadSize = 5, prefetchDistance = 5),
        pagingSourceFactory = {StorePagingSource(storeApi, header)}
    ).liveData

    override suspend fun getBrandData(header: String) = withContext(Dispatchers.IO){
        storeApi.getBrandeData(header)
    }

    override suspend fun getDetailsData(header: String, productId: String) = withContext(Dispatchers.IO) {
        storeApi.getDetailsData(header, productId)
    }

}