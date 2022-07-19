package com.example.homwork11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homwork11.databinding.CustomItemBinding


class ItemAdapter(private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val list = mutableListOf<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(CustomItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = list.size

    inner class ItemViewHolder(private val binding: CustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var items: ItemData

        fun bind() {
            items = list[adapterPosition]

            binding.apply {
                tvFirstName.text = items.firstName
                tvLastName.text = items.lastname
                ivFavouriteItem.setImageResource(items.image)
                ivDeleteItem.setImageResource(items.trashImage)
            }

            binding.root.setOnClickListener {
                onItemClick.onItemClicked(adapterPosition)
            }

            binding.ivDeleteItem.setOnClickListener {
                list.removeAt(adapterPosition)
                setItems(list)
            }
        }
    }

    fun setItems(newItems: List<ItemData>) {
        val diff = ItemDIffUtils(newList = newItems, oldList = list)
        val result = DiffUtil.calculateDiff(diff)
        this.list.clear()
        this.list.addAll(newItems)
        result.dispatchUpdatesTo(this)
    }
}
