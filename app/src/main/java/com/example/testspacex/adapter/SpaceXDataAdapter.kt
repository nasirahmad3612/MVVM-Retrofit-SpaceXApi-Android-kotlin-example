package com.example.testspacex.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testspacex.model.SpaceXModelItem
import com.example.testspacex.R
import com.example.testspacex.databinding.DatarowBinding
import com.example.testspacex.view.DetailActivit

class SpaceXDataAdapter(private val context: Context):
    RecyclerView.Adapter<SpaceXDataAdapter.RocketViewHolder>() {
    private var list:List<SpaceXModelItem> = ArrayList()

    fun setDataList(list: List<SpaceXModelItem>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:DatarowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.datarow, parent, false)
        return RocketViewHolder(binding)
    }
    override fun onBindViewHolder(holder: SpaceXDataAdapter.RocketViewHolder, position: Int) {
        holder.bind(list[position])
        holder.datarowBinding.itemView.setOnClickListener {
            val activity = context as AppCompatActivity
            val intent = Intent(activity, DetailActivit::class.java)
            intent.putExtra("DataId",list[position].id)
            activity.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = list.size

    inner class RocketViewHolder(var datarowBinding: DatarowBinding):
        RecyclerView.ViewHolder(datarowBinding.root) {

        fun bind(rocketData: SpaceXModelItem) {
            val v: View? = null
            datarowBinding.rocketData = rocketData
            val childMembersAdapter = rocketData.flickr_images?.let {
                SpaceXChildAdapter(context,
                    it
                )
            }
            datarowBinding.rvFlicker.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            datarowBinding.rvFlicker.adapter = childMembersAdapter
            datarowBinding.rocketData

        }


    }
}