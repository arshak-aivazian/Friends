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
import com.example.friends.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKAuthParams
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), LoginView {
    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter
    @ProvidePresenter
    fun providePresenter() : LoginPresenter{
        val router = (application as MyApp).router
        return LoginPresenter(router)
    }

    private val authCallback = object : VKAuthCallback {
        override fun onLogin(token: VKAccessToken) {
            loginPresenter.onLoginSuccess()
        }

        override fun onLoginFailed(errorCode: Int) {
            loginPresenter.onLoginFailed(errorCode.toString())
        }
    }

    lateinit var holder: NavigatorHolder
    lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        holder = (application as MyApp).navigationHolder
        navigator = SupportAppNavigator(this, 0)
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        holder.removeNavigator()
        super.onPause()
    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLoginScreen() {
        val params = VKAuthParams(resources.getInteger(R.integer.com_vk_sdk_AppId), setOf(VKScope.OFFLINE, VKScope.FRIENDS, VKScope.PHOTOS))
        val intent = Intent(this, VKWebViewAuthActivity::class.java)
            .putExtra(VKWebViewAuthActivity.VK_EXTRA_AUTH_PARAMS, params.toBundle())
        startActivityForResult(intent, 282)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        VK.onActivityResult(requestCode, resultCode, data, authCallback)
    }

}
