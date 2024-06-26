package com.example.namaz_app.intersept

import okhttp3.Interceptor
import okhttp3.Response

class Intercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
        val url=request.header("apikey")
    }
}