package com.deromang.domain.modules.api

import com.deromang.domain.data.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("3/movie/popular")
    fun showModel(
        @Query("api_key") apiKey: String,
    ): Call<ResponseModel>

    @GET("3/search/movie")
    fun searchModel(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): Call<ResponseModel>

}