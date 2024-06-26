package com.example.namaz_app.data.repository

import com.example.namaz_app.data.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrayRepository @Inject constructor(private val apiManager: ApiService) {

    suspend fun getPrayDate(city: String) = withContext(Dispatchers.IO) {
        try {
            val response = apiManager.getNamazData(city)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@withContext NetworkResponse.Success(it.result)
                }
            } else {
                return@withContext NetworkResponse.Error(response.errorBody().toString())
            }
        } catch (e: Exception) {
            return@withContext NetworkResponse.Error(e.localizedMessage?.toString())
        }
    }

}