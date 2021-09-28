package com.example.testspacex.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.testspacex.Api.BASEURL
import com.example.testspacex.Api.networkCall
import com.example.testspacex.model.SpaceXModelItem
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsRepository(val application: Application) {

        val showProgress = MutableLiveData<Boolean>()
        val reponseData = MutableLiveData<SpaceXModelItem>()

    fun getDataById(id:String){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val dataService = retrofit.create(networkCall::class.java)

        dataService.getDataById(id).enqueue(object :Callback<SpaceXModelItem>{
            override fun onResponse(
                call: Call<SpaceXModelItem>,
                response: Response<SpaceXModelItem>
            ) {
                showProgress.value = false
                val response = response.body()
                reponseData.value = response
                Log.d("RESPONSEDATA","Response Data: ${Gson().toJson(response)}")
            }

            override fun onFailure(call: Call<SpaceXModelItem>, t: Throwable) {
                showProgress.value = false
                Log.d("DETAISDATA","Details data Error ${t.toString()}")
                Toast.makeText(application,"Some things went wrong",Toast.LENGTH_SHORT).show()
            }

        })
    }
}