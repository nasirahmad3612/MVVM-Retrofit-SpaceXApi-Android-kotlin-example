package com.example.testspacex.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpaceXModelItem(

    @SerializedName("country") val country: String?,
    @SerializedName("flickr_images") val flickr_images: ArrayList<String>?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("active") val active:Boolean,
    @SerializedName("cost_per_launch") val cost_per_launch:Int?,
    @SerializedName("success_rate_pct") val success_rate_pct:Int?,
    @SerializedName("wikipedia") val wikipedia:String?,
//    @SerializedName("height") val height : Height,
//    @SerializedName("diameter") val diameter : Diameter,
){

}






