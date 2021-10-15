package com.example.moviesapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {

    companion object {
        var movieApiService: MovieApiService? = null
        private const val BASE_URL = "https://howtodoandroid.com/"

        fun getInstance(): MovieApiService {
            if (movieApiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                movieApiService = retrofit.create(MovieApiService::class.java)
            }
            return movieApiService!!
        }
    }

}