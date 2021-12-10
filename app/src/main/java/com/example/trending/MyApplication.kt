package com.example.trending

import android.app.Application
import com.example.trending.di.DaggerRetroComponent
import com.example.trending.di.RetroComponent
import com.example.trending.di.RetroModule

class MyApplication : Application() {

    private lateinit var retroComponent:RetroComponent
    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getComponent():RetroComponent{
        return retroComponent
    }
}