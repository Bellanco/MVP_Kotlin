package com.deromang.domain.modules.api

import com.deromang.domain.data.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("competitions")
    fun showCompetitions(): Call<ResponseModel>

}