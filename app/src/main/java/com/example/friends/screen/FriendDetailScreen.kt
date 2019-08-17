package com.example.friends.screen

import android.content.Context
import android.content.Intent
import com.example.friends.activities.FriendDetailActivity
import com.example.friends.model.entity.friends.VkFriend
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendDetailScreen(private val friend: VkFriend) : SupportAppScreen() {

    companion object {
        const val KEY_FRIEND = "KEY_FRIEND"
    }

    override fun getActivityIntent(context: Context?): Intent {
        return Intent(context, FriendDetailActivity::class.java)
            .putExtra(KEY_FRIEND, friend)
    }
}