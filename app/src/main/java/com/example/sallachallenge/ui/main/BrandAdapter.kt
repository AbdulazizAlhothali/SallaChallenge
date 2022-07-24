package com.example.sallachallenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sallachallenge.R
import com.example.sallachallenge.databinding.StaticItemBinding
import com.example.sallachallenge.models.brand.BrandData

class BrandAdapter (private val brand: List<BrandData>): RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val bind = DataBindingUtil.inflate<StaticItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.static_item, parent, false
        )
        return BrandViewHolder(bind)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val storeBrand = brand[position]
        holder.bind(storeBrand)
    }

    override fun getItemCount(): Int {
        return brand.size
    }



    class BrandViewHolder(private val binding: StaticItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(brandData: BrandData){
            binding.brand = brandData

        }
    }
}