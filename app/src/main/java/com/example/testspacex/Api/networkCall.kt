package com.example.testspacex.Api

import com.example.testspacex.model.SpaceXModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val BASEURL= "https://api.spacexdata.com/v4/"
interface networkCall {

    @GET("rockets")
    fun getSpaceXList(): Call<List<SpaceXModelItem>>

    @GET("rockets/{id}")
    fun getDataById(@Path("id") id:String):Call<SpaceXModelItem>
}