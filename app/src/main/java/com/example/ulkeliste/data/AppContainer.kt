package com.example.ulkeliste.data

import com.example.ulkeliste.network.CountryApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val countryRepository: CountryRepository
}


class DefaultAppContainer : AppContainer{
    private val baseUrl = "https://restcountries.com/v3.1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory("application/json".toMediaType()))
        .build()



    private val retrofitService : CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)

    }

    override val countryRepository: CountryRepository by lazy {
        NetworkCountryRepository(retrofitService)
    }



}