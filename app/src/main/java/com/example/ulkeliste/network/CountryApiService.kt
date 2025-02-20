package com.example.ulkeliste.network

import com.example.ulkeliste.model.CountryModel
import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    suspend fun getAllCountries(): List<CountryModel>
}
