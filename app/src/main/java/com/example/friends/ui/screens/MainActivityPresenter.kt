package com.example.friends.ui.screens

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.ui.screens.MainActivityView

@InjectViewState
class MainActivityPresenter(): MvpPresenter<MainActivityView>() {
    fun navigateToLoginFragment(){
        viewState.showLoginFragment()
    }
}