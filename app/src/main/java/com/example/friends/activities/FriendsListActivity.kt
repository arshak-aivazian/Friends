package com.example.friends.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.adapters.FriendsAdapter
import com.example.friends.adapters.FriendsAdapter.FriendsListener
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.presenters.FriendsListPresenter
import com.example.friends.views.FriendsListView
import kotlinx.android.synthetic.main.activity_friends_list.*
import kotlinx.android.synthetic.main.friend_item.view.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class FriendsListActivity : MvpAppCompatActivity(), FriendsListView {


    @InjectPresenter
    lateinit var friendsListPresenter: FriendsListPresenter

    @ProvidePresenter
    fun providePresenter() : FriendsListPresenter{
        val router = (application as MyApp).router
        return FriendsListPresenter(router)
    }

    val adapter = FriendsAdapter()
    lateinit var holder: NavigatorHolder
    lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        holder = (application as MyApp).navigationHolder
        navigator = SupportAppNavigator(this, 0)
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

    override fun setupFriendsList(friendsList: List<VkFriend>) {
        adapter.setupFriends(friendsList)
    }

}
