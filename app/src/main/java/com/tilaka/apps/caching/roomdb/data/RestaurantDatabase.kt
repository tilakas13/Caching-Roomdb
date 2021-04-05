package com.tilaka.apps.caching.roomdb.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RestaurantModel::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}