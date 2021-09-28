package com.example.testspacex.Api

import android.util.Log
import com.example.testspacex.model.SpaceXModelItem
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitServices {

    private val retrofit: RetrofitApis =
        RetrofitClient.ServiceBuilder.buildService(RetrofitApis::class.java)

    fun getSpaceXData(onResult: (List<SpaceXModelItem>?) -> Unit){
        retrofit.getSpaceXList().enqueue(object : Callback<List<SpaceXModelItem>>{
            override fun onResponse(
                call: Call<List<SpaceXModelItem>>,
                response: Response<List<SpaceXModelItem>>
            ) {
                val spaceXDataList = response.body()
                onResult(spaceXDataList)
                Log.d("SPACEXDATA","SpaceX Data ${Gson().toJson(spaceXDataList)}")
            }
            override fun onFailure(call: Call<List<SpaceXModelItem>>, t: Throwable) {
                onResult(null)
            }

        })
    }
    fun getSpaceXDataById(id:String,onResult: (SpaceXModelItem?) -> Unit){
        retrofit.getDataById(id).enqueue(object : Callback<SpaceXModelItem>{
            override fun onResponse(
                call: Call<SpaceXModelItem>,
                response: Response<SpaceXModelItem>
            ) {
                val spaceXData = response.body()
                onResult(spaceXData)
            }

            override fun onFailure(call: Call<SpaceXModelItem>, t: Throwable) {
                onResult(null)
            }

        })
    }


}