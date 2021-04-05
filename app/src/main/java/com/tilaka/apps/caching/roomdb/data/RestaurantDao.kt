package com.tilaka.apps.caching.roomdb.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurants")
    fun getAllRestaurants(): Flow<List<RestaurantModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurants: List<RestaurantModel>)

    @Query("DELETE FROM restaurants")
    suspend fun deleteAllRestaurants()
}