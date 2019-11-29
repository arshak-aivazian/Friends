package com.example.friends.network.repository

import com.example.friends.network.entity.photo.VkPhotoResponse
import com.example.friends.network.requests.PhotosRequest
import com.google.gson.Gson
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class PhotoRepositiry {
    private val gson = Gson()

    fun getPhotos(userId: Int, callback: VKApiCallback<VkPhotoResponse>){
        VK.execute(PhotosRequest(userId,gson),callback)
    }
}