package com.example.moviesapp.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RestApi {

    companion object {
        var movieService: MovieService? = null
        private const val BASE_URL = "https://howtodoandroid.com/"

        @Singleton
        @Provides
        fun providesMovieService(): MovieService {
            if (movieService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                movieService = retrofit.create(MovieService::class.java)
            }
            return requireNotNull(movieService)
        }
    }

}
