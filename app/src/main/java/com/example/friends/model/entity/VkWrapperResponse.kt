package com.example.friends.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class VkWrapperResponse<T>(
    @field:SerializedName("response")
    @Expose
    var response: T
) : Serializable