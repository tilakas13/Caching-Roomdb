package com.tilaka.apps.custom.caching.roomdb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tilaka.apps.custom.caching.roomdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)


        val newFragment: Fragment = RestaurantFragment()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment_container, newFragment).commit()
    }
}