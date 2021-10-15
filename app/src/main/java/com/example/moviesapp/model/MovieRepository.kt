package com.example.moviesapp.model

import com.example.moviesapp.api.MovieApiService

class MovieRepository(private val movieApiService: MovieApiService) {

    suspend fun getAllMovies() = movieApiService.getAllMovies()
}
