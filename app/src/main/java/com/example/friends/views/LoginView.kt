package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface LoginView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToLoginScreen()
    fun showError(text: String)
    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateTofriendsList()
}