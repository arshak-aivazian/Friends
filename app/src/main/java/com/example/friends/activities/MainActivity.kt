package com.example.friends.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.presenters.LoginPresenter
import com.example.friends.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope

class MainActivity : MvpAppCompatActivity(), LoginView {
    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    //не понятно
    private val authCallback = object : VKAuthCallback{
        override fun onLogin(token: VKAccessToken) {
            loginPresenter.onLoginSuccess()
        }
        override fun onLoginFailed(errorCode: Int) {
            loginPresenter.onLoginFailed(errorCode.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToFriendsListScreen() {
        startActivity(Intent(this, FriendsListActivity::class.java))
    }

    override fun navigateToLoginScreen() {
        VK.login(this, setOf(VKScope.OFFLINE,VKScope.FRIENDS))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        VK.onActivityResult(requestCode,resultCode,data,authCallback)
    }

}
