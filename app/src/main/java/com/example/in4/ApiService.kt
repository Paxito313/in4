package com.example.in4.network

import retrofit2.http.GET
import retrofit2.Call
import com.example.in4.data.RealEstate

interface ApiService {
    @GET("realestate")
    fun getRealEstateList(): Call<List<RealEstate>>
}
