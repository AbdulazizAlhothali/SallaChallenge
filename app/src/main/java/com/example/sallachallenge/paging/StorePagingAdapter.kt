package com.example.sallachallenge.paging

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sallachallenge.R
import com.example.sallachallenge.databinding.RecyclerViewItemBinding
import com.example.sallachallenge.models.items.Data
import com.example.sallachallenge.ui.main.MainFragmentDirections

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
            val font = "myfonts/DINNextLTArabic-Regular.ttf"

            binding.font = font
            binding.tvTest.text = store.name
            binding.imageView2.load(store.thumbnail)
            if (store.promotion.title != null){
                binding.ivPromo.visibility = View.VISIBLE
                binding.tvPromo.text = store.promotion.title
            } else {
                binding.ivPromo.visibility = View.GONE
            }
            binding.imageView2.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(store.id.toString())
                binding.root.findNavController().navigate(action)
            }


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