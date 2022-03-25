package com.ssepulveda.swearwords.data

import com.ssepulveda.swearwords.network.ApiService
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val api: ApiService
) {
    suspend fun getResultJson(text: String) = api.getResultJson(text)

    suspend fun isContainsProfanity(text: String) = api.isContainsProfanity(text)
}
