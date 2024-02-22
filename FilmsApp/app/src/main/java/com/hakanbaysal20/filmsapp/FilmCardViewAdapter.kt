package com.hakanbaysal20.filmsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso

class FilmCardViewAdapter(private val mContext:Context,private val filmList:List<Film>)
    :RecyclerView.Adapter<FilmCardViewAdapter.FilmCardViewHolder>(){

    inner class FilmCardViewHolder(view:View):ViewHolder(view){
        val filmName:TextView
        val filmCardView:CardView
        val imageView:ImageView

        init {
            filmName = view.findViewById(R.id.filmName)
            filmCardView = view.findViewById(R.id.filmCardView)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardViewHolder {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.films_card_view,parent,false)
        return FilmCardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmCardViewHolder, position: Int) {
        val film = filmList.get(position)
        Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${film.filmImage.toLowerCase()}").into(holder.imageView)
        holder.filmName.text = film.filmName
        holder.filmCardView.setOnClickListener {
            val intent = Intent(mContext,FilmDetailActivity::class.java)
            intent.putExtra("film",film)
            mContext.startActivity(intent)
        }
    }
}