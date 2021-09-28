package com.example.testspacex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testspacex.R
import com.example.testspacex.adapter.SpaceXChildAdapter
import com.example.testspacex.adapter.SpaceXDataAdapter
import com.example.testspacex.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.datarow.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainActivityViewModel
    private lateinit var adapterX:SpaceXDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getDataX()
        viewModel.showProgress.observe(this, {
            if (it)
                mainProgress.visibility = View.VISIBLE
            else
                mainProgress.visibility = View.GONE
        })

        viewModel.dataList.observe(this, {
            adapterX.setDataList(it)
        })


        adapterX = SpaceXDataAdapter(this)
        rvMainData.layoutManager = LinearLayoutManager(this)
        rvMainData.adapter = adapterX


    }
}