package com.example.moviesapp.api

import com.example.moviesapp.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movielist.json")
    suspend fun getAllMovies(): Response<List<Movie>>
}
