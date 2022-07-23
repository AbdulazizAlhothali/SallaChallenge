package com.example.sallachallenge.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.sallachallenge.models.items.Data
import com.example.sallachallenge.models.brand.BrandData
import com.example.sallachallenge.models.details.DetailsBase

interface StoreRepo {
    fun getStoreData(header: String): LiveData<PagingData<Data>>

    suspend fun getBrandData(header: String): BrandData

    suspend fun getDetailsData(header: String, productId: String): DetailsBase
}