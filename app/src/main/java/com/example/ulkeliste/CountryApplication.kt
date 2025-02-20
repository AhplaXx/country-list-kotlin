package com.example.ulkeliste

import android.app.Application
import com.example.ulkeliste.data.AppContainer
import com.example.ulkeliste.data.DefaultAppContainer

class CountryApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}