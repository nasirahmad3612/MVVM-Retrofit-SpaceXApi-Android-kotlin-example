package com.example.testspacex.view

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testspacex.R
import com.example.testspacex.adapter.SpaceXChildAdapter
import com.example.testspacex.databinding.ActivityDetailBinding
import com.example.testspacex.viewmodel.DetailActivityViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivit : AppCompatActivity() {
    lateinit var viewModel:DetailActivityViewModel
    lateinit var adapter:SpaceXChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProvider(this).get(DetailActivityViewModel::class.java)

        if (intent.hasExtra("DataId")){
            val id = intent.getStringExtra("DataId").toString()

            if (id != null){
                viewModel.getDetails(id)
            }
        }
        viewModel.showProgress.observe(this, Observer {
            if (it){
                detailProgressBar.visibility = View.VISIBLE
            }
            else{
                detailProgressBar.visibility = View.GONE
            }
        })

        viewModel.response.observe(this, Observer {
            tvName.text = it.name.toString()
            tvCost.text = it.cost_per_launch.toString()
            tvDescription.text = it.description.toString()
            tvSuccessRate.text = it.success_rate_pct.toString()
            tvWikipediaLink.text = it.wikipedia.toString()
            if (it.active == true){
                tvStatus.text = "Active"
            }
            else{
                tvStatus.text = "Not Active"
            }
            adapter = it.flickr_images?.let { it1 -> SpaceXChildAdapter(this, it1) }!!

            rvDetailsFlickr.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            rvDetailsFlickr.adapter = adapter

        })

    }

}