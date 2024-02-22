package com.hakanbaysal20.filmsappretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FilmCardViewAdapter(private val context:Context,private val filmList:List<Film>)
    :RecyclerView.Adapter<FilmCardViewAdapter.CardViewHolder>(){

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val cardView:CardView
        val filmName:TextView
        val imageView:ImageView

        init {
            cardView = view.findViewById(R.id.filmCardView)
            filmName = view.findViewById(R.id.textFilmName)
            imageView = view.findViewById(R.id.filmImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.film_card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val film = filmList.get(position)
        holder.filmName.text = film.filmName
        Picasso.get().load("http://kasimadalan.pe.hu/filmler/resimler/${film.filmImage}").into(holder.imageView)
        holder.cardView.setOnClickListener {
            val intent = Intent(context,FilmDetailActivity::class.java)
            intent.putExtra("film",film)
            context.startActivity(intent)
        }
    }
}