package com.example.sallachallenge.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sallachallenge.R
import com.example.sallachallenge.databinding.RecyclerViewItemBinding
import com.example.sallachallenge.model.Data

class StorePagingAdapter: PagingDataAdapter<Data, StorePagingAdapter.StoreViewHolder>(Comparator()) {




    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val bind = DataBindingUtil.inflate<RecyclerViewItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recycler_view_item, parent, false
        )
        return StoreViewHolder(bind)
    }

    class StoreViewHolder(private val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(store: Data){
            binding.tvTest.text = store.name
        }
    }

    class Comparator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}