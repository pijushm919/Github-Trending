package com.example.trending.di

import com.example.trending.models.TrendingRepo
import retrofit2.Call
import retrofit2.http.GET

interface RetroService{
    @GET("repositories")
    fun getAllData():Call<List<TrendingRepo>>?
}