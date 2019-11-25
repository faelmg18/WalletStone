package br.com.rafaelhfernandes.core.framework.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class BaseResponse<T>(
    @SerializedName("@odata.context") val info: String,
    @SerializedName("value") val results: List<T>
)