package com.example.sallachallenge.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.sallachallenge.model.Data
import com.example.sallachallenge.retrofit.StoreApi
import retrofit2.HttpException
import java.io.IOException

class StorePagingSource(private val storeApi: StoreApi) : PagingSource<Int, Data>(){
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val position = params.key ?: 1
            val response = storeApi.getStoreData(page = position, params.loadSize )
            return LoadResult.Page(
                data = response.data,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if(position == 7) null else position + 1
            )
        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}