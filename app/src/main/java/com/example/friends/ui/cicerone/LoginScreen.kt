package com.example.friends.ui.cicerone


import com.example.friends.ui.screens.login.LoginFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LoginScreen: SupportAppScreen() {
    override fun getFragment(): LoginFragment {
        return LoginFragment.getNewInstance()
    }
}