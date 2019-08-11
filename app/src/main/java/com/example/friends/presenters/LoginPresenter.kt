package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.views.LoginView
import com.vk.api.sdk.VK


@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if(VK.isLoggedIn()){
            viewState?.navigateToFriendsListScreen()
        }else{
            viewState?.navigateToLoginScreen()
        }
    }

    fun onLoginSuccess(){
        viewState?.navigateToFriendsListScreen()
    }

    fun onLoginFailed(error: String){
        viewState?.showError(error)
    }

}