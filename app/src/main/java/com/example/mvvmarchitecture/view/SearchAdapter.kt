package com.example.mvvmarchitecture.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.databinding.SearchItemBinding
import com.example.mvvmarchitecture.model.restaurant.Restaurant
import com.squareup.picasso.Picasso

class SearchAdapter(private val restaurantList: List<Restaurant>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private lateinit var binding: SearchItemBinding

    class SearchViewHolder(private val searchItemBinding: SearchItemBinding) :
        RecyclerView.ViewHolder(searchItemBinding.root) {
        fun bind(restaurant: Restaurant) {
            searchItemBinding.restaurant = restaurant
            Picasso.get().load(restaurant.photograph).placeholder(R.drawable.placeholder).into(searchItemBinding.itemImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(restaurantList.get(position))
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

}