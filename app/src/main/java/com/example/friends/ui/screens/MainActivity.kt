package com.example.friends.ui.screens

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.ui.screens.MainActivityPresenter
import com.example.friends.ui.screens.MainActivityView
import com.example.friends.ui.screens.login.LoginFragment

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainActivityView {
    lateinit var fragmentManager: FragmentManager
    lateinit var holder: NavigatorHolder
    lateinit var navigator: SupportAppNavigator

    @InjectPresenter
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        holder = (application as MyApp).navigationHolder
        navigator = SupportAppNavigator(this, fragmentManager, R.id.container)

        mainActivityPresenter.navigateToLoginFragment()
    }

    override fun onResume() {
        super.onResume()
        holder.setNavigator(navigator)
    }

    override fun onPause() {
        holder.removeNavigator()
        super.onPause()
    }

    override fun showLoginFragment() {
        fragmentManager.beginTransaction().add(R.id.container, LoginFragment.getNewInstance()).commit()
    }

}
