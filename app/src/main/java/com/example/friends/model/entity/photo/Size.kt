package com.example.friends.model.entity.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Size(
    @field:SerializedName("url")
    @Expose
    val src: String,
    @field:SerializedName("width")
    @Expose
    val width: Int,
    @field:SerializedName("height")
    @Expose
    val height: Int,
    @field:SerializedName("type")
    @Expose
    val type: String
)