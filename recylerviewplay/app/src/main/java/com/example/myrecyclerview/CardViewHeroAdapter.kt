package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero:ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivHero: ImageView = itemView.findViewById(R.id.imageViewPhotoUI)
        var tvName: TextView = itemView.findViewById(R.id.tvHeroNameUI)
        var tvDetail:TextView = itemView.findViewById(R.id.tvDetailHeroUI)
        var btnFav : Button = itemView.findViewById(R.id.btnSetFavUI)
        var btnShare: Button = itemView.findViewById(R.id.btnShareUI)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero,parent,false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {

        val hero = listHero[position]

        Glide.with((holder.itemView.context))
            .load(hero.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.ivHero)


        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.btnFav.setOnClickListener { Toast.makeText(holder.itemView.context, "Favourite ${listHero[holder.adapterPosition].name}", Toast.LENGTH_SHORT ).show() }

        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share ${listHero[holder.adapterPosition].name}", Toast.LENGTH_SHORT ).show() }

        holder.itemView.setOnClickListener {Toast.makeText(holder.itemView.context, "Pick ${listHero[holder.adapterPosition].name}", Toast.LENGTH_SHORT).show()}





    }

    override fun getItemCount(): Int = listHero.size
}