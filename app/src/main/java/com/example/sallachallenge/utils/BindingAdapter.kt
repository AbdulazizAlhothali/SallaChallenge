package com.example.sallachallenge.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("changeColor")
fun changeBackGround(view: View,colorStr: String){
    val color = colorStr.toUIntOrNull()
    if (color != null) {
        view.setBackgroundColor(color.toInt())
    }
}

@BindingAdapter("loadimage")
fun loadImage(image: ImageView, imageUri: String?){
    if (imageUri != null){
        image.load(imageUri)
    }

}