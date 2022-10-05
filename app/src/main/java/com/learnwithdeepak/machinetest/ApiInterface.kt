package com.learnwithdeepak.machinetest

import com.learnwithdeepak.machinetest.model.Datalist
import com.learnwithdeepak.machinetest.model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getData() : Call<List<Datalist>>

    @GET("photos")
    fun getphotosData() : Call<List<PhotoModel>>

}