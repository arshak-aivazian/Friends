package com.example.friends.screen

import android.os.Bundle
import com.example.friends.fragments.FriendDetailFragment
import com.example.friends.model.entity.friends.VkFriend
import ru.terrakok.cicerone.android.support.SupportAppScreen


class FriendDetailScreen(private val friend: VkFriend) : SupportAppScreen() {

    companion object {
        const val KEY_FRIEND = "KEY_FRIEND"
    }

    override fun getFragment(): FriendDetailFragment {
        val fragment = FriendDetailFragment.getNewInstance()
        val args = Bundle()
        args.putSerializable(KEY_FRIEND, friend)
        fragment.arguments = args
        return fragment
    }
}