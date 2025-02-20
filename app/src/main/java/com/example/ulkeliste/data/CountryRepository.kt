package com.example.ulkeliste.data

import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.network.CountryApiService

interface CountryRepository {
    suspend fun getCountries(): List<CountryModel>
}


class NetworkCountryRepository (
    private val countryApiService: CountryApiService
) : CountryRepository {
    override suspend fun getCountries(): List<CountryModel> = countryApiService.getAllCountries()
}