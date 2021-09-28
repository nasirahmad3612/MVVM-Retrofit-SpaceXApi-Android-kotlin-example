package com.example.testspacex.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testspacex.R
import androidx.databinding.DataBindingUtil

import androidx.databinding.ViewDataBinding

import android.view.LayoutInflater

import android.view.ViewGroup





@BindingAdapter("android:loadImage")
fun loadCircularImage(view: ImageView, loadImage: ArrayList<String>) {

    if (loadImage == null || loadImage.isEmpty()) {
        return
    }
        Glide.with(view.context).load(loadImage)
            .placeholder(
                R.drawable.spacex
            )
            .into(view)
}
/*
@BindingAdapter(value = ["setBooks"])
fun RecyclerView.setBooks(books: List<Book>?) {
    if (books != null) {
        val bookAdapter = BookAdapter()
        bookAdapter.submitList(books)

        adapter = bookAdapter
    }
}
 */


//
//@BindingAdapter("entries", "layout")
//fun <T> setEntries(
//    viewGroup: ViewGroup,
//    entries: List<T>?, layoutId: Int
//) {
//    viewGroup.removeAllViews()
//    if (entries != null) {
//        val inflater = viewGroup.context
//            .getSystemService<Any>(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        for (i in entries.indices) {
//            val entry = entries[i]
//            val binding = DataBindingUtil
//                .inflate<ViewDataBinding>(inflater, layoutId, viewGroup, true)
//            binding.setVariable(BR.data, entry)
//        }
//    }
//}




