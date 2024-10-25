package com.example.in4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.in4.data.RealEstate
import com.example.in4.data.RealEstateRepository
import kotlinx.coroutines.launch

class RealEstateViewModel : ViewModel() {
    private val repository = RealEstateRepository()
    val realEstateList: LiveData<List<RealEstate>> = repository.realEstateList

    init {
        fetchRealEstateList()
    }

    private fun fetchRealEstateList() = viewModelScope.launch {
        repository.fetchRealEstateList()
    }
}
