package com.example.friends.ui.screens.friend_list

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.friends.model.entity.friends.VkFriend

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsListView: MvpView {
    fun showError(text: String)
    fun setupFriendsList(friendsList: List<VkFriend>)
}