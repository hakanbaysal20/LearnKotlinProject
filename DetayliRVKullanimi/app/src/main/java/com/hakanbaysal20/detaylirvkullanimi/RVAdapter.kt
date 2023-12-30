package com.hakanbaysal20.detaylirvkullanimi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val mContext:Context,private val filmler:List<Films>)
    : RecyclerView.Adapter<RVAdapter.CardViewObjectsHolder>(){

    inner class CardViewObjectsHolder(view:View):RecyclerView.ViewHolder(view){

        var textViewBaslik : TextView
        var textViewFiyat : TextView
        var imageViewFilmResim: ImageView
        var buttonSepeteEkle: Button

        init {
            textViewBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFiyat = view.findViewById(R.id.textViewFilmFiyat)
            imageViewFilmResim = view.findViewById(R.id.imageViewFilmResim)
            buttonSepeteEkle = view.findViewById(R.id.buttonSepeteEkle)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewObjectsHolder {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_film_tasarim,parent,false)
        return CardViewObjectsHolder(tasarim)
    }

    override fun getItemCount(): Int {
        return filmler.size
    }

    override fun onBindViewHolder(holder: CardViewObjectsHolder, position: Int) {
        val film = filmler[position]
        val resimAdi = film.filmResimAdi
        holder.textViewBaslik.text = film.filmIsim
        holder.textViewFiyat.text = "${film.filmFiyat} TL"
        holder.imageViewFilmResim.setImageResource(
            mContext.resources.getIdentifier(film.filmResimAdi,"drawable",mContext.packageName))
        holder.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(mContext,"${film.filmIsim} sepete eklendi",Toast.LENGTH_SHORT).show()
        }
    }
}
