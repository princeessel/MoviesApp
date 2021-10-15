package com.example.moviesapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.ListMoviesBinding
import com.example.moviesapp.view.OnItemClickListener

class MovieAdapter(private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList = mutableListOf<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListMoviesBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.apply {
            movieName.text = movie.name

            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageUrl)
        }
        holder.bind(movie, itemClickListener, position)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(val binding: ListMoviesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: OnItemClickListener, position: Int){
            itemView.setOnClickListener {
                clickListener.onItemClick(index = position, movie = movie)
            }

        }
    }

}
