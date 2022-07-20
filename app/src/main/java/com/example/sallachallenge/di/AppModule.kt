package com.example.sallachallenge.di

import com.example.sallachallenge.repo.StoreRepo
import com.example.sallachallenge.repo.StoreRepoImpl
import com.example.sallachallenge.retrofit.StoreApi
import com.example.sallachallenge.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideStoreApi(retrofit: Retrofit): StoreApi {
        return retrofit.create(StoreApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepo(storeApi: StoreApi): StoreRepo {
        return StoreRepoImpl(storeApi)
    }
}