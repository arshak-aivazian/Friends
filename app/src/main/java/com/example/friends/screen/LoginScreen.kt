package com.example.friends.screen


import com.example.friends.fragments.LoginFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LoginScreen: SupportAppScreen() {
    override fun getFragment(): LoginFragment {
        return LoginFragment.getNewInstance()
    }
}