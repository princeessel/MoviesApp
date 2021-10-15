package com.example.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.moviesapp.Movie
import com.example.moviesapp.model.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel
: ViewModel() {
    private lateinit var movieRepository: MovieRepository
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    fun init(movieRepository: MovieRepository
    ) {
        this.movieRepository = movieRepository
    }


    fun getAllMovies() {
        viewModelScope.launch {
            val response = movieRepository.getAllMovies()

            if (!response.isSuccessful) {
                _errorMessage.postValue("An Error Occurred")
            }
            _movieList.postValue(response.body())
        }

    }

}
