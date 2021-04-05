package com.tilaka.apps.caching.roomdb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tilaka.apps.caching.roomdb.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(repository: RestaurantRepository) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()
}