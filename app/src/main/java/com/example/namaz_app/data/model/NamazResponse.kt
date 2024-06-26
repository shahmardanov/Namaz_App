package com.alijan.demo.data.model


import com.google.gson.annotations.SerializedName

data class NamazResponse(
    @SerializedName("result")
    val result: List<Pray>,
    @SerializedName("success")
    val success: Boolean?
)