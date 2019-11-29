package com.example.friends.ui.cicerone

import androidx.core.app.Fragment
import com.example.friends.ui.screens.friend_list.FriendsListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendListScreen : SupportAppScreen(){
    override fun getFragment(): FriendsListFragment {
        return FriendsListFragment.getNewInstance()
    }

}