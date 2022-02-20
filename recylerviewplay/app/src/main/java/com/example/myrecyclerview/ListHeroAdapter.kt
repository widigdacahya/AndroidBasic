package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ListHeroAdapter(private val listHero:ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName:TextView = itemView.findViewById(R.id.tvHeroNameUI)
        var tvDetail:TextView = itemView.findViewById(R.id.tvDetailHeroUI)
        var ivHero: ImageView = itemView.findViewById(R.id.imageViewPhotoUI)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.ivHero)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail


        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listHero.size




    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}