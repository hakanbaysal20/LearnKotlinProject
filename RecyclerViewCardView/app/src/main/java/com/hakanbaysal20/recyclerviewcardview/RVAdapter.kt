package com.hakanbaysal20.recyclerviewcardview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class RVAdapter(private val mContext:Context,private val ulkelerListesi:List<Ulkeler>)
    : RecyclerView.Adapter<RVAdapter.CardViewTasarimNesneleriniTutucu>() {

    inner class CardViewTasarimNesneleriniTutucu(view:View):RecyclerView.ViewHolder(view){

        var satirCardView:CardView
        var satirYazi:TextView
        var satirImage:ImageView

        init {
            satirCardView = view.findViewById(R.id.satirCardView)
            satirYazi = view.findViewById(R.id.satirYazi)
            satirImage = view.findViewById(R.id.satirImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewTasarimNesneleriniTutucu {
     val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarimi,parent,false)
        return CardViewTasarimNesneleriniTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return ulkelerListesi.size
    }

    override fun onBindViewHolder(holder: CardViewTasarimNesneleriniTutucu, position: Int) {
        val ulke = ulkelerListesi[position]
        holder.satirYazi.text = ulke.ulkeAdi
        holder.satirCardView.setOnClickListener{
            Toast.makeText(mContext,"Seçilen ülke : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
        }
        holder.satirImage.setOnClickListener {
            val popup = PopupMenu(mContext,holder.satirImage)
            popup.menuInflater.inflate(R.menu.menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.ayarlar -> {
                        Toast.makeText(mContext,"Ayarlandı : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.cikis ->{
                        Toast.makeText(mContext,"Çıkıldı : ${ulke.ulkeAdi}",Toast.LENGTH_SHORT).show()

                        true
                    }
                    else -> false

                }
            }
        }

    }
}