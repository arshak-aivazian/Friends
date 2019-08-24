package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsDetailView:MvpView {
    fun showFriendInfo(userName: String, avatar: String)
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateToPotos(userId: Int)

}