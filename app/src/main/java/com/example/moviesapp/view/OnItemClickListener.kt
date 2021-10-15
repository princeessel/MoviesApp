package com.example.moviesapp.view

import com.example.moviesapp.Movie

interface OnItemClickListener {
    fun onItemClick(index : Int, movie : Movie)
}
