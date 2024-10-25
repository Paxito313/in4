package com.example.in4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RealEstateViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RealEstateViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RealEstateViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

