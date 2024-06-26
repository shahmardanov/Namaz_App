package com.example.namaz_app.data.api

import com.alijan.demo.data.model.NamazResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("pray/all")
    suspend fun getNamazData(@Query("data.city") city: String ): Response<NamazResponse>
}
