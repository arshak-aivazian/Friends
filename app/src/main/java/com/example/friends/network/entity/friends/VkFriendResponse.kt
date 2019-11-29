package com.example.friends.network.entity.friends

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VkFriendResponse(
    @field:SerializedName("count")
    @Expose
    val count: Int,
    @field:SerializedName("items")
    @Expose
    val items: List<VkFriend>
): Serializable
