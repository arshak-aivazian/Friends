package com.example.friends.screen

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.example.friends.activities.FriendsListActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendListScreen : SupportAppScreen(){

    override fun getActivityIntent(context: Context?): Intent {
        return Intent(context,FriendsListActivity::class.java)
    }

}