package com.example.friends.ui.screens.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.ui.cicerone.FriendListScreen
import com.vk.api.sdk.VK
import ru.terrakok.cicerone.Router


@InjectViewState
class LoginPresenter(private val router: Router) : MvpPresenter<LoginView>() {

    fun onLogin() {
        if (VK.isLoggedIn()) {
            router.navigateTo(FriendListScreen())
        } else {
            viewState?.navigateToLoginScreen()
        }
    }

    fun onLoginSuccess() {
        router.navigateTo(FriendListScreen())
    }

    fun onLoginFailed(error: String) {
        viewState?.showError(error)
    }


}