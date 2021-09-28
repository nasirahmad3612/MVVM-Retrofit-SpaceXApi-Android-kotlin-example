package com.example.testspacex.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testspacex.model.SpaceXModelItem
import com.example.testspacex.repository.DetailsRepository

class DetailActivityViewModel(application: Application):AndroidViewModel(application) {

    private val repository = DetailsRepository(application)
    val showProgress :LiveData<Boolean>
    val response:LiveData<SpaceXModelItem>
    init {
        this.showProgress = repository.showProgress
        this.response = repository.reponseData
    }

      fun getDetails(id: String){
          repository.getDataById(id)
      }
}