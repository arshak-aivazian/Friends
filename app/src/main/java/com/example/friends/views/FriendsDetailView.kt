package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.friends.pojo.Friend

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsDetailView:MvpView {
    fun showDetail(id: Int)
    fun showError(text: String)
}