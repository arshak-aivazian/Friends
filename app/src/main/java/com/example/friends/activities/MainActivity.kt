package com.example.friends.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.presenters.LoginPresenter
import com.example.friends.views.LoginView
import com.vk.sdk.util.VKUtil

class MainActivity : MvpAppCompatActivity(), LoginView {
    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName())
        Log.i("fingerprint", fingerprints[0])

    }

    override fun showError(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsListActivity::class.java))
    }
}
