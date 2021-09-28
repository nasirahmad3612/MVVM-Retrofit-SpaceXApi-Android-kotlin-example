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

class MainActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val dataList = MutableLiveData<List<SpaceXModelItem>>()

    fun changeState(){
        showProgress.value =!(showProgress.value != null && showProgress.value!!)
    }

    fun getDataSpaceX(){
        showProgress.value = true
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(networkCall::class.java)
        service.getSpaceXList().enqueue(object : Callback<List<SpaceXModelItem>>{
            override fun onResponse(
                call: Call<List<SpaceXModelItem>>,
                response: Response<List<SpaceXModelItem>>
            ) {
                showProgress.value = false
                val response = response.body()
                dataList.value = response
                Log.d("DATA","Response:${Gson().toJson(response)}")
            }
            override fun onFailure(call: Call<List<SpaceXModelItem>>, t: Throwable) {
                showProgress.value = false
                Log.d("MYDATAERROR","Response:${t.toString()}")
                Toast.makeText(application,"SomeThing went wrong",Toast.LENGTH_SHORT).show()
            }

        })
    }
}
