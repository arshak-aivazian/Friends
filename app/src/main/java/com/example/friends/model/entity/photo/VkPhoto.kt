package com.example.friends.model.entity.photo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class VkPhoto(
    @field:SerializedName("id")
    @Expose
    val id: Int,
    @field:SerializedName("album_id")
    @Expose
    val albumId: Int,
    @field:SerializedName("owner_id")
    @Expose
    val ownerId: Int,
    @field:SerializedName("sizes")
    @Expose
    val sizes: List<Size>?,
    @field:SerializedName("text")
    @Expose
    val text: String?,
    @field:SerializedName("date")
    @Expose
    val date: Long,
    @field:SerializedName("post_id")
    @Expose
    val postId: Int,
    @field:SerializedName("has_filter")
    @Expose
    val hasFilter: Int
)