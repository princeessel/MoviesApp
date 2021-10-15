//package com.example.moviesapp.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.moviesapp.model.MovieRepository
//import java.lang.IllegalArgumentException
//
//class ViewModelFactory constructor(private val repository: MovieRepository): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
//           MovieViewModel(this.repository) as T
//        } else {
//            throw IllegalArgumentException("ViewModel Not found")
//        }
//    }
//}