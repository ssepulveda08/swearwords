package com.ssepulveda.swearwords.network.models

import com.google.gson.annotations.SerializedName

data class JsonResponses(
    @SerializedName("result") val result: String,
)