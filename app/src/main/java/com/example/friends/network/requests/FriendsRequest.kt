package com.example.friends.network.requests

import com.example.friends.network.entity.friends.VkFriendResponse
import com.example.friends.network.entity.VkWrapperResponse
import com.example.friends.utils.fromJson
import com.google.gson.Gson
import com.vk.api.sdk.requests.VKRequest

class FriendsRequest(private val gson: Gson) : VKRequest<VkFriendResponse>("friends.get") {

    init {
        addParam("fields","nickname, domain, sex, bdate, city, country, timezone, photo_50, photo_200, photo_200_orig, has_mobile, contacts, education, online, relation, last_seen, status, can_write_private_message, can_see_all_posts, can_post, universities")
    }

    override fun parse(response: String): VkFriendResponse {
        try {
            val vkResponse = gson.fromJson<VkWrapperResponse<VkFriendResponse>>(response)
            return vkResponse.response
        }catch (e: Throwable){
            e.printStackTrace()
            throw e
        }
    }

}