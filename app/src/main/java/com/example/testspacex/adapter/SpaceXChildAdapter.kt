package com.example.testspacex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testspacex.R

class SpaceXChildAdapter(val context: Context, private val ImgUrls: ArrayList<String>):
    RecyclerView.Adapter<SpaceXChildAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): SpaceXChildAdapter.ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.imagerow, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpaceXChildAdapter.ImageViewHolder, position: Int) {
//        Glide.with(context).load(ImgUrls[position]).into(holder.img_android)
                holder.bind(ImgUrls[position])
    }

    override fun getItemCount(): Int = ImgUrls.size
    inner class ImageViewHolder(val view:View):
        RecyclerView.ViewHolder(view) {

        fun bind(dataImage: String) {
            val imageView = view.findViewById<ImageView>(R.id.ivList)
            Glide.with(view.context).load(dataImage).centerCrop().into(imageView)

        }
//        Glide.with(view.context).load(property.image).centerCrop().into(imageView)

    }
}