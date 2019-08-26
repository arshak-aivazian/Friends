package com.example.friends.screen

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.example.friends.fragments.FriendsListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendListScreen : SupportAppScreen(){
    override fun getFragment(): FriendsListFragment {
        return FriendsListFragment.getNewInstance()
    }

}