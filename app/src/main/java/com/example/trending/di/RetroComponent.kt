package com.example.trending.di

import com.example.trending.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {
    fun inject(viewModel: MainViewModel)
}