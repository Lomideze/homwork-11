package com.example.homwork11

import androidx.recyclerview.widget.DiffUtil

class ItemDIffUtils(val newList: List<ItemData>,val oldList: List<ItemData>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition].firstName == oldList[oldItemPosition].firstName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }
}