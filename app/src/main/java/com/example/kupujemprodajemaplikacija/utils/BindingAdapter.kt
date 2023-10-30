package com.example.kupujemprodajemaplikacija.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kupujemprodajemaplikacija.R

object BindingAdapter {
    @JvmStatic
    @androidx.databinding.BindingAdapter("app:glideImage")
    fun setGlideImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(Constants.IMAGE_URL + url)
            .centerInside()
            .error(R.drawable.no_image)
            .into(imageView)
    }

    @JvmStatic
    @androidx.databinding.BindingAdapter("app:favImage")
    fun setFav(imageView: ImageView, isFav: Boolean?) {
        Glide.with(imageView.context)
            .load(if (isFav!!) R.drawable.favorite_selected else R.drawable.favorite_no_selected)
            .centerInside()
            .error(R.drawable.favorite_no_selected)
            .into(imageView)
    }
}