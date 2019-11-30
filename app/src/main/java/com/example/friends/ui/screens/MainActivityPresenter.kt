package com.example.friends.ui.screens

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainActivityPresenter(): MvpPresenter<MainActivityView>() {
    fun navigateToLoginFragment(){
        viewState.showLoginFragment()
    }
}