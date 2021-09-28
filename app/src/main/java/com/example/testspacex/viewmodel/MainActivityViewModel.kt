package com.example.testspacex.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testspacex.model.SpaceXModelItem
import com.example.testspacex.repository.MainActivityRepository

class MainActivityViewModel(application: Application): AndroidViewModel(application) {

        val repository = MainActivityRepository(application)
        val showProgress:LiveData<Boolean>
        val dataList:LiveData<List<SpaceXModelItem>>

        init {
            this.showProgress = repository.showProgress
            this.dataList = repository.dataList
        }
    fun changeState(){
        repository.changeState()
    }
    fun getDataX(){
        repository.getDataSpaceX()
    }
}