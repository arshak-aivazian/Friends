package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.friends.model.entity.VkFriend
import com.example.friends.model.entity.VkFriendResponse

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsListView: MvpView {


    fun showError(text: String)
    fun setupFriendsList(friendsList: List<VkFriend>)
    fun showFriendDetail(id: Int)
}