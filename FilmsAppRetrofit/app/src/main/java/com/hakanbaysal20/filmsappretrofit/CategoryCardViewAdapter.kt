package com.hakanbaysal20.filmsappretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CategoryCardViewAdapter(private val context:Context,private val categoryList:List<Category>)
    :RecyclerView.Adapter<CategoryCardViewAdapter.CardViewHolder>(){

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){

        val cardView:CardView
        val categoryName:TextView

        init {
            cardView = view.findViewById(R.id.categoryCardView)
            categoryName = view.findViewById(R.id.textCategoryName)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.category_card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryName.text = category.categoryName
        holder.cardView.setOnClickListener {
            val intent = Intent(context,GetFilmActivity::class.java)
            intent.putExtra("categoryId",category.categoryId)
            context.startActivity(intent)
        }
    }
}