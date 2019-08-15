package com.example.friends.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.adapters.FriendsAdapter
import com.example.friends.adapters.FriendsAdapter.FriendsListener
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.presenters.FriendsListPresenter
import com.example.friends.views.FriendsListView
import kotlinx.android.synthetic.main.activity_friends_list.*
import kotlinx.android.synthetic.main.friend_item.view.*

class FriendsListActivity : MvpAppCompatActivity(), FriendsListView {


    @InjectPresenter
    lateinit var friendsListPresenter: FriendsListPresenter

    val adapter = FriendsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)
        recyclreViewFriends.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        recyclreViewFriends.adapter = adapter


        adapter.setFriendsListener(object : FriendsListener {
            override fun onSelectFriend(friend: VkFriend) {
                friendsListPresenter.onFriendSelected(friend)
            }
        })

        adapter.setItemFriendsListener(object : FriendsAdapter.ItemFriendsListener{
            override fun onClickButtonItem(friend: VkFriend) {
                friendsListPresenter.navigateToPhotos(friend.id)
            }
        })

    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun setupFriendsList(friendsList: List<VkFriend>) {
        adapter.setupFriends(friendsList)
    }

    override fun showFriendDetail(friend: VkFriend) {
        FriendDetailActivity.startActivity(this,friend)
    }

    override fun showPhotos(userId: Int) {
        PhotosActivity.startActivity(this, userId)
    }
}
