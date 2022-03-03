package com.example.cahyasanote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cahyasanote.databinding.ItemSaBinding

class ListArchAdapter(private val listArchitecure: ArrayList<Architecture>): RecyclerView.Adapter<ListArchAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemSaBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemSaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (archName, archDesc, archUsage,archShortcomings, archDiagram, archIcon) = listArchitecure[position]
        holder.binding.tvSaTitleUI.text = archName
        holder.binding.tvSaDescUI.text = archDesc
        holder.binding.ivIconSaUI.setImageResource(archIcon)


    }

    override fun getItemCount(): Int = listArchitecure.size
}