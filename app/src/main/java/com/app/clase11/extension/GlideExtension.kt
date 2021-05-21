package com.app.clase11.extension

import android.widget.ImageView
import com.app.clase11.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?){
    val options = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.ic_baseline_shopping_cart_24)
        .error(R.drawable.ic_launcher_foreground)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}