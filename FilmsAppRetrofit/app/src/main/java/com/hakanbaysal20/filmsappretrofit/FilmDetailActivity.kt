package com.hakanbaysal20.filmsappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.filmsappretrofit.databinding.ActivityFilmDetailBinding
import com.squareup.picasso.Picasso

class FilmDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFilmDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val film = intent.getSerializableExtra("film") as Film
        binding.detailTextCategoryName.text = film.category.categoryName
        binding.detailTextFilmDirector.text = film.director.directorName
        binding.detailTextFilmName.text = film.filmName
        binding.detailTextFilmYear.text = film.filmYear
        Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${film.filmImage}").into(binding.detailFilmImageView)
    }
}