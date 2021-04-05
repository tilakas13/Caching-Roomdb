package com.tilaka.apps.caching.roomdb.api

import com.tilaka.apps.caching.roomdb.data.RestaurantModel
import retrofit2.http.GET

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<RestaurantModel>
}