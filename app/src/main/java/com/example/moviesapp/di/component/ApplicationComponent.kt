package com.example.moviesapp.di.component

import com.example.moviesapp.view.MainActivity
import com.example.moviesapp.api.RestApi
import com.example.moviesapp.view.MovieDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RestApi::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(movieDetailsActivity: MovieDetailsActivity)
}
