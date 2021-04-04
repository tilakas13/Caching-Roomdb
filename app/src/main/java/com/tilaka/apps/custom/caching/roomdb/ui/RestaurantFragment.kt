package com.tilaka.apps.custom.caching.roomdb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilaka.apps.custom.caching.roomdb.databinding.FragmentRestaurantBinding
import com.tilaka.apps.custom.caching.roomdb.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    private val viewModel: RestaurantViewModel by viewModels()
    private lateinit var binding: FragmentRestaurantBinding
    private val restaurantAdapter = RestaurantAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerviewHotels.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }

        viewModel.restaurants.observe(viewLifecycleOwner) { result ->
            restaurantAdapter.submitList(result.data)
            binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            binding.textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            binding.textViewError.text = result.error?.localizedMessage
        }
    }
}