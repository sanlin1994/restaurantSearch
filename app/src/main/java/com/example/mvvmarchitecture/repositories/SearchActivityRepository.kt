package com.sanlin.myarchitecture.repositories

import android.content.Context
import com.example.mvvmarchitecture.model.Menu.Menus
import com.example.mvvmarchitecture.model.restaurant.Restaurants
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.stream.Collectors
import javax.inject.Inject

class SearchActivityRepository @Inject constructor(@ApplicationContext context: Context) {

    private var jsonMenu:String
    private var jsonRestaurant:String

    init {
        jsonMenu = context.assets.open("Menus.json").bufferedReader().use {
            it.readText()
        }
        jsonRestaurant = context.assets.open("Restaurants.json").bufferedReader().use {
            it.readText()
        }
    }

    private fun getMenus() = Gson().fromJson(jsonMenu, Menus::class.java).menus
    private fun getRestaurants() = Gson().fromJson(jsonRestaurant, Restaurants::class.java).restaurants

    fun searchRestaurant(searchQuery:String) = getRestaurants().stream().filter {checkInMenu(it.id,searchQuery)||
            it.name.lowercase().contains(searchQuery) || it.address.lowercase().contains(searchQuery) || it.cuisine_type.lowercase().contains(searchQuery)
    }.collect(Collectors.toList())

    fun checkInMenu(restaurantId:Int, searchQuery:String):Boolean{
        return getMenus().stream().filter{it.restaurantId == restaurantId}.flatMap { it.categories.stream() }.flatMap { it.menuItems.stream() }.filter {
            it.name.lowercase().contains(searchQuery) || it.description.lowercase().contains(searchQuery)
        }.collect(Collectors.toList()).size>0
    }

}