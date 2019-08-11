package com.example.friends.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.adapters.FriendsAdapter
import com.example.friends.model.entity.VkFriend
import com.example.friends.model.entity.VkFriendResponse
import com.example.friends.presenters.FriendsListPresenter
import com.example.friends.views.FriendsListView
import kotlinx.android.synthetic.main.activity_friends_list.*

class FriendsListActivity : MvpAppCompatActivity(), FriendsListView {
    @InjectPresenter
    lateinit var friendsListPresenter: FriendsListPresenter

    val adapter = FriendsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)
        recyclreViewFriends.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        recyclreViewFriends.adapter = adapter
    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun setupFriendsList(friendsList: List<VkFriend>) {
        adapter.setupFriends(friendsList)
    }
    override fun showFriendDetail(id: Int) {
        val intent = Intent(this, FriendDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}
