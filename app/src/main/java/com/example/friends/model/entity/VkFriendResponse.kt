package com.example.friends.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VkFriendResponse(
    @field:SerializedName("count")
    @Expose
    val count: Int,
    @field:SerializedName("items")
    @Expose
    val items: List<VkFriend>
)
