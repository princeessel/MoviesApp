package com.example.moviesapp.model

import com.example.moviesapp.api.MovieService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieService: MovieService) {
    suspend fun getAllMovies() = movieService.getAllMovies()
}
