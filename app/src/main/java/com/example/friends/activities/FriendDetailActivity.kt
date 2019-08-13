package com.example.friends.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.model.entity.VkFriend
import com.example.friends.presenters.FriendDetailPresenter
import com.example.friends.views.FriendsDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_friend_detail.*
import kotlinx.android.synthetic.main.friend_item.view.*

class FriendDetailActivity : MvpAppCompatActivity(), FriendsDetailView {
    @InjectPresenter
    lateinit var friendDetailPresenter: FriendDetailPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        val intent: Intent = intent
        val friend = intent.getSerializableExtra("friendObject") as VkFriend

        friendDetailPresenter.setFriendDetail(friend)
    }

    override fun showFriendInfo(userName: String, avatar: String) {
        textView.text = userName
        Picasso.get().load(avatar).into(imageViewPhoto)
    }



}
