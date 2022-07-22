package com.example.sallachallenge.retrofit

import com.example.sallachallenge.models.items.BaseStoreData
import com.example.sallachallenge.models.brand.BrandData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface StoreApi {


    @GET("brands/259940351?")
    suspend fun getStoreData(@Header("Store-Identifier") header: String, @Query("page") page: Int, @Query("per_page") per_page: Int): BaseStoreData



    @GET("brands/259940351?")
    suspend fun getBrandeData(@Header("Store-Identifier") header: String): BrandData
}