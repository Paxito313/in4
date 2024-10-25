package com.example.in4.data

import com.example.in4.network.RetrofitClient
import com.example.in4.data.RealEstate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RealEstateRepository {
    private val _realEstateList = MutableLiveData<List<RealEstate>>()
    val realEstateList: LiveData<List<RealEstate>> get() = _realEstateList

    fun fetchRealEstateList() {
        val call = RetrofitClient.retrofitInstance.getRealEstateList()
        call.enqueue(object : Callback<List<RealEstate>> {
            override fun onResponse(call: Call<List<RealEstate>>, response: Response<List<RealEstate>>) {
                if (response.isSuccessful) {
                    _realEstateList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<RealEstate>>, t: Throwable) {
                // Manejo de errores aquí
            }
        })
    }
}
