package com.example.friends.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VkCity (
    @field:SerializedName("id")
    @Expose
    var id: Int,
    @field:SerializedName("title")
    @Expose
    var title: String
): Serializable