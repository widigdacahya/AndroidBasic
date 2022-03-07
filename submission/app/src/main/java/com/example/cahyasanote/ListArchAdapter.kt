package com.example.cahyasanote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cahyasanote.databinding.ItemSaBinding

class ListArchAdapter(private val listArchitecure: ArrayList<Architecture>): RecyclerView.Adapter<ListArchAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Architecture)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemSaBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemSaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (archName, archDesc, _archUsage, _archShortcomings, _archDiagram, archIcon, _archExp) = listArchitecure[position]
        holder.binding.tvSaTitleUI.text = archName
        holder.binding.tvSaDescUI.text = archDesc
        holder.binding.ivIconSaUI.setImageResource(archIcon)

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listArchitecure[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listArchitecure.size
}