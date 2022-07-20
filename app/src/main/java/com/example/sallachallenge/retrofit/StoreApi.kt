package com.example.sallachallenge.retrofit

import com.example.sallachallenge.model.BaseStoreData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface StoreApi {

    @Headers("Store-Identifier: 1328842359")
    @GET("brands/259940351?")
    suspend fun getStoreData(@Query("page") page: Int, @Query("per_page") per_page: Int): BaseStoreData
}