package com.example.friends.network.entity.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VkPhotoResponse (
    @field:SerializedName("count")
    @Expose
    val count: Int,
    @field:SerializedName("items")
    @Expose
    val items: List<VkPhoto>
)