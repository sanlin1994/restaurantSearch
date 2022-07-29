package com.example.mvvmarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanlin.myarchitecture.repositories.SearchActivityRepository
import com.sanlin.myarchitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SearchActivityViewModel @Inject constructor(private val searchActivityRepository: SearchActivityRepository): ViewModel() {

    fun searchResturant(searchQuery:String)  = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(searchActivityRepository.searchRestaurant(searchQuery)))
        }catch (exception:Exception){
            emit(Resource.error(exception.localizedMessage,data = null))
        }
    }

}