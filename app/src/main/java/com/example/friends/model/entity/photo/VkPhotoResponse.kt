package com.example.friends.model.entity.photo

import com.example.friends.model.entity.friends.VkFriend
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