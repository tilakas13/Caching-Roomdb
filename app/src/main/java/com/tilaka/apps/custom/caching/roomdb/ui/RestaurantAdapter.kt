package com.tilaka.apps.custom.caching.roomdb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilaka.apps.custom.caching.roomdb.data.RestaurantModel
import com.tilaka.apps.custom.caching.roomdb.databinding.ItemRestaurantBinding

class RestaurantAdapter :
    ListAdapter<RestaurantModel, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    class RestaurantViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: RestaurantModel) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageHotel)

                nameHotel.text = restaurant.hotelName
                textViewType.text = restaurant.hotelType
                textViewAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<RestaurantModel>() {
        override fun areItemsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
            oldItem.hotelName == newItem.hotelName

        override fun areContentsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
            oldItem == newItem
    }


}