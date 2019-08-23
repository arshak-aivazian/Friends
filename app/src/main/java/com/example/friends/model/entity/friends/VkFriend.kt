package com.example.friends.model.entity.friends

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VkFriend (
    @field:SerializedName("id")
    @Expose
    val id: Int,
    @field:SerializedName("first_name")
    @Expose
    val firstName: String?,
    @field:SerializedName("last_name")
    @Expose
    val lastName: String?,
    @field:SerializedName("domain")
    @Expose
    val domain: String?,
    @field:SerializedName("city")
    @Expose
    val city: VkCity?,
    @field:SerializedName("online")
    @Expose
    val online: Int,
    @field:SerializedName("photo_200_orig")
    @Expose
    val photo_200: String
) : Serializable