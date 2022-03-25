package com.ssepulveda.swearwords.network

import com.ssepulveda.swearwords.network.models.JsonResponses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("json")
    suspend fun getResultJson(
        @Query("text") text: String,
    ) : Response<JsonResponses>

    @GET("containsprofanity")
    suspend fun isContainsProfanity(
        @Query("text") text: String,
    ) : Response<Boolean>
}