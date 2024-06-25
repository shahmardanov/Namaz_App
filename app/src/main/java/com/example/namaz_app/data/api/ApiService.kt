package com.example.namaz_app.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("service/economy/coin/list")
    suspend fun getAllCity(@Query("apiKey") apiKey: String = "gvloSjuIbqB3u0EDg5OrFcIOG2ac74gAgi46NVEYweHnNfaEcF6yajYAxC8M")
            : Response<CoinModel>
}
}