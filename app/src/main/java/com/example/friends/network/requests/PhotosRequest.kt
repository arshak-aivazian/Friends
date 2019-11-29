package com.example.friends.network.requests

import com.example.friends.network.entity.VkWrapperResponse
import com.example.friends.network.entity.photo.VkPhotoResponse
import com.example.friends.utils.fromJson
import com.google.gson.Gson
import com.vk.api.sdk.requests.VKRequest

class PhotosRequest(userId: Int, private val gson: Gson) : VKRequest<VkPhotoResponse>("photos.getAll") {

    init {
        addParam("owner_id", "$userId")
        addParam("count",10)
        addParam("photo_sizes",1)

    }

    override fun parse(response: String): VkPhotoResponse {
        try {
            val vkResponse = gson.fromJson<VkWrapperResponse<VkPhotoResponse>>(response)
            return vkResponse.response
        }catch (e: Throwable){
            e.printStackTrace()
            throw e
        }
    }

}