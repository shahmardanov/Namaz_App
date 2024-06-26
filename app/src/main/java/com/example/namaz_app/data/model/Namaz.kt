package com.alijan.demo.data.model


import com.google.gson.annotations.SerializedName

data class Namaz(
    @SerializedName("saat")
    val saat: String?,
    @SerializedName("vakit")
    val vakit: String?
)