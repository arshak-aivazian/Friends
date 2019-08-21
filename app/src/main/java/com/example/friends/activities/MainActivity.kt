package com.example.friends.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.presenters.LoginPresenter
import com.example.friends.screen.LoginScreen
import com.example.friends.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKAuthParams
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(){

    lateinit var holder: NavigatorHolder
    lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        holder = (application as MyApp).navigationHolder
        navigator = SupportAppNavigator(this, fragmentManager, R.id.container)

        //???????????????????как переделать??????????????
        (application as MyApp).router.navigateTo(LoginScreen())
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        holder.removeNavigator()
        super.onPause()
    }
}
