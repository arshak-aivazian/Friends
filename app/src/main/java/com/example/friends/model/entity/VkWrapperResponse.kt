package com.example.friends.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class VkWrapperResponse<T>(
    @field:SerializedName("response")
    @Expose
    var response: T
)