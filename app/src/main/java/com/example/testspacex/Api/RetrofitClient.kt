package com.example.testspacex.Api

import com.example.testspacex.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    object ServiceBuilder{

        private var gson: Gson = GsonBuilder()
            .setLenient()
            .create()
        private val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_API_PATH_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        fun <T> buildService(service:Class<T>):T{
            return retrofit.create(service)
        }

    }
}