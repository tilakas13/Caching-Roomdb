package com.tilaka.apps.custom.caching.roomdb.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tilaka.apps.custom.caching.roomdb.data.RestaurantDao
import com.tilaka.apps.custom.caching.roomdb.data.RestaurantModel

@Database(entities = [RestaurantModel::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}