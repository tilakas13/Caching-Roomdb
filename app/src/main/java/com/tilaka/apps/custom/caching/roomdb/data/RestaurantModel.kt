package com.tilaka.apps.custom.caching.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "restaurants")
data class RestaurantModel (

	@PrimaryKey
	@Expose
	@SerializedName("id")
	val hotelId : Int,
	@Expose
	@SerializedName("uid")
	val uid : String,
	@Expose
	@SerializedName("name")
	val hotelName : String,
	@Expose
	@SerializedName("type")
	val hotelType : String,
	@Expose
	@SerializedName("description")
	val description : String,
	@Expose
	@SerializedName("review")
	val review : String,
	@Expose
	@SerializedName("logo")
	val logo : String,
	@Expose
	@SerializedName("phone_number")
	val phoneNumber : String,
	val address : String,
	//val hours : Hours
)