package com.example.moviesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.ActivityMovieDetailsBinding
import com.example.moviesapp.di.component.MyApplication
import com.example.moviesapp.model.MovieRepository
import com.example.moviesapp.viewmodel.MovieDetailsViewModel
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    @Inject
    lateinit var repository: MovieRepository

    private val viewModel by viewModels<MovieDetailsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MyApplication).appComponent.inject(this)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        getMovie()
        initObservers()
    }

    private fun initViewModel() {
        viewModel.init(repository)
    }

    private fun initObservers() {
        viewModel.movie.observe(this, {
            binding.movieName.apply {
                text = it?.name
            }

            binding.movieCategory.apply {
                text = it?.category
            }

            binding.imageMovie.apply {
                Glide.with(binding.imageMovie).load(it?.imageUrl).into(binding.imageMovie)
            }
        })
    }

    private fun getMovie() {
        val index = intent.getIntExtra("Movie Index", 0)
        viewModel.getMovieDetail(index)
    }
}
