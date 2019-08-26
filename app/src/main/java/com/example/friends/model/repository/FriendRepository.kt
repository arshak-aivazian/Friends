package com.example.friends.model.repository

import com.example.friends.model.entity.friends.VkFriendResponse
import com.example.friends.model.requests.FriendsRequest
import com.google.gson.Gson
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class FriendRepository{

    private val gson = Gson()

    fun getFriends(callback: VKApiCallback<VkFriendResponse>){
        VK.execute(FriendsRequest(gson),callback)
    }

}