package com.example.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.api.MovieApi
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.model.MovieRepository
import com.example.moviesapp.view.MovieDetailsActivity
import com.example.moviesapp.view.OnItemClickListener
import com.example.moviesapp.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MovieAdapter(this)

    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        initViewModel()
        initObservers()
        getAllMovies()
    }

    private fun initViewModel() {
        val apiService = MovieApi.getInstance()
        val repository = MovieRepository(apiService)
        viewModel.init(repository)
    }

    private fun getAllMovies() {
        viewModel.getAllMovies()
    }

    private fun initObservers() {
        viewModel.movieList.observe(this, { movies ->
            if(movies != null) {
                adapter.setMovies(movies)
            } else{
                Toast.makeText(this, "Error in getting List", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onItemClick(index: Int, movie: Movie) {
            val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                putExtra("Movie Index", index)
            }
            startActivity(intent)
    }
}
