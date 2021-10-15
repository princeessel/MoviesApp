package com.example.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.Movie
import com.example.moviesapp.model.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel: ViewModel() {

    private lateinit var movieRepository: MovieRepository

    private val _movie = MutableLiveData<Movie?>()
    val movie: LiveData<Movie?> = _movie

    fun init(movieRepository: MovieRepository) {
        this.movieRepository = movieRepository
    }

    fun getMovieDetail(position: Int) {
        viewModelScope.launch {
            val response = movieRepository.getAllMovies()

            val movie = response.body().let {
                it?.get(position)
            }
            _movie.postValue(movie)
        }
    }
}
