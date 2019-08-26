package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.screen.LoginScreen
import com.example.friends.views.LoginView
import com.example.friends.views.MainActivityView
import ru.terrakok.cicerone.Router

@InjectViewState
class MainActivityPresenter(): MvpPresenter<MainActivityView>() {
    fun navigateToLoginFragment(){
        viewState.showLoginFragment()
    }
}