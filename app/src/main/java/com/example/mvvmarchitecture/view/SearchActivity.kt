package com.example.mvvmarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.databinding.ActivityMainBinding
import com.example.mvvmarchitecture.model.restaurant.Restaurant
import com.example.mvvmarchitecture.viewmodel.SearchActivityViewModel
import com.sanlin.myarchitecture.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private val TAG:String = "MainActivity"
    private val searchActivityViewModel: SearchActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var restaurantList:ArrayList<Restaurant> = arrayListOf()
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.restaurantRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.restaurantRecyclerView.setHasFixedSize(true)
        searchAdapter = SearchAdapter(restaurantList)
        //binding.restaurantRecyclerView.adapter = searchAdapter

        binding.searchEditText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchRestaurant(p0.toString().lowercase())
            }
            override fun afterTextChanged(p0: Editable?) {

            }

        })

        searchRestaurant("")

    }

    private fun searchRestaurant(searchQuery: String){
        searchActivityViewModel.searchResturant(searchQuery).observe(this, Observer {
            when(it.status){
                Status.LOADING -> Log.i(TAG, "Loading")
                Status.ERROR -> Log.i(TAG,it.message)
                Status.SUCCESS -> {
                    restaurantList.clear()
                    restaurantList.addAll(it.data!!)
                    //searchAdapter.notifyDataSetChanged()
                    binding.restaurantRecyclerView.adapter = searchAdapter
                }
            }
        })
    }
}