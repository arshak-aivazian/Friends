package com.example.friends.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.activities.MainActivity
import com.example.friends.presenters.LoginPresenter
import com.example.friends.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKAuthParams
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : MvpAppCompatFragment(), LoginView {


    companion object{
        fun getNewInstance(): LoginFragment{
            return LoginFragment()
        }
    }

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter


    private val authCallback = object : VKAuthCallback {
        override fun onLogin(token: VKAccessToken) {
            loginPresenter.onLoginSuccess()
        }

        override fun onLoginFailed(errorCode: Int) {
            loginPresenter.onLoginFailed(errorCode.toString())
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonEnter.setOnClickListener({
            loginPresenter.onLogin()
        })
    }

    override fun showError(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToLoginScreen() {
        val params = VKAuthParams(resources.getInteger(R.integer.com_vk_sdk_AppId), setOf(VKScope.OFFLINE, VKScope.FRIENDS, VKScope.PHOTOS))
        val intent = Intent(activity, VKWebViewAuthActivity::class.java)
            .putExtra(VKWebViewAuthActivity.VK_EXTRA_AUTH_PARAMS, params.toBundle())
        startActivityForResult(intent, 282)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        VK.onActivityResult(requestCode, resultCode, data, authCallback)
    }

    override fun navigateTofriendsList() {
        FriendsListFragment.toFriendsListFragment(activity as MainActivity)
    }
}
