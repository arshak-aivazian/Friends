package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.friends.model.entity.VkFriend

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsDetailView:MvpView {
    fun showFriendInfo(userName: String, avatar: String)
}