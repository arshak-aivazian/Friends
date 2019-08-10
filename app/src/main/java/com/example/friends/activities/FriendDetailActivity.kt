package com.example.friends.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.presenters.FriendDetailPresenter
import com.example.friends.views.FriendsDetailView

class FriendDetailActivity : MvpAppCompatActivity(), FriendsDetailView {
    @InjectPresenter
    lateinit var friendDetailPresenter: FriendDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)
    }

    override fun showDetail(id: Int) {

    }

    override fun showError(text: String) {

    }
}
