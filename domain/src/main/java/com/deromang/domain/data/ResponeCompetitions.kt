package com.deromang.domain.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


data class ResponseModel(

    @SerializedName("count") val count: Int,
    @SerializedName("competitions") val competitions: List<Competitions>
)

data class Area(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class Competitions(

    @SerializedName("id") val id: Int,
    @SerializedName("area") val area: Area,
    @SerializedName("name") val name: String,
    @SerializedName("code") val code: String,
    @SerializedName("plan") val plan: String,
    @SerializedName("currentSeason") val currentSeason: CurrentSeason,
    @SerializedName("numberOfAvailableSeasons") val numberOfAvailableSeasons: Int,
    @SerializedName("lastUpdated") val lastUpdated: String
)

data class CurrentSeason(

    @SerializedName("id") val id: Int,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("endDate") val endDate: String,
    @SerializedName("currentMatchday") val currentMatchday: String
)

