package com.hakanbaysal20.filmsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.filmsapp.databinding.ActivityFilmDetailBinding
import com.squareup.picasso.Picasso

class FilmDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFilmDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val film = intent.getSerializableExtra("film") as Film

        binding.filmDetailToolbar.setTitle(film.filmName)
        binding.filmDetailToolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(binding.filmDetailToolbar)
        Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${film.filmImage.toLowerCase()}").into(binding.detailFilmImage)
        binding.detailFilmYear.text = film.filmYear
        binding.detailFilmName.text = film.filmName
        binding.detailFilmCategory.text = film.category.categoryName
        binding.detailFilmDirector.text = film.filmDirector.directorName

    }
}