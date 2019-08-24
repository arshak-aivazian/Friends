package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.views.LoginView



@InjectViewState
class LoginPresenter() : MvpPresenter<LoginView>() {
//      не работает
//    override fun onFirstViewAttach() {
//        super.onFirstViewAttach()
//        if (VK.isLoggedIn()) {
//            router.navigateTo(FriendListScreen())
//        }
//    }

    fun onLogin() {
        viewState?.navigateToLoginScreen()
    }

    fun onLoginSuccess() {
        viewState?.navigateTofriendsList()
    }

    fun onLoginFailed(error: String) {
        viewState?.showError(error)
    }


}