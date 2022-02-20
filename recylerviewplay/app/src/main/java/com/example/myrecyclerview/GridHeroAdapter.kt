package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val listHero: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivHero: ImageView = itemView.findViewById(R.id.imageViewPhotoUI)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridHeroAdapter.GridViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero,parent,false)
        return GridViewHolder(view)

    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(listHero[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.ivHero)


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