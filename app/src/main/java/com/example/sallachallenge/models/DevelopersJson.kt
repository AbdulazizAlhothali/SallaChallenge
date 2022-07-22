package com.example.sallachallenge.models

import com.google.gson.annotations.SerializedName

data class DevelopersJson(
    @SerializedName("id")
    var id: String,
    @SerializedName("store")
    var store: String,
    @SerializedName("app_color")
    var app_color: String,
    @SerializedName("font_family")
    var font_family: String)
