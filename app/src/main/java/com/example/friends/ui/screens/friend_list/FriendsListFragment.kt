package com.example.friends.ui.screens.friend_list


import android.os.Bundle
import androidx.core.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.network.entity.friends.VkFriend


class FriendsListFragment : MvpAppCompatFragment(),
    FriendsListView {

    companion object{
        fun getNewInstance(): FriendsListFragment {
            return FriendsListFragment()
        }
    }

    @InjectPresenter
    lateinit var friendsListPresenter: FriendsListPresenter

    @ProvidePresenter
    fun providePresenter() : FriendsListPresenter {
        val router = (activity?.application as MyApp).router
        return FriendsListPresenter(router)
    }

    val adapter = FriendsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclreViewFriends.layoutManager = LinearLayoutManager(activity, OrientationHelper.VERTICAL, false)
        recyclreViewFriends.adapter = adapter


        adapter.setFriendsListener(object : FriendsAdapter.FriendsListener {
            override fun onSelectFriend(friend: VkFriend) {
                friendsListPresenter.onFriendSelected(friend)
            }
        })

        adapter.setItemFriendsListener(object : FriendsAdapter.ItemFriendsListener{
            override fun onClickButtonItem(friend: VkFriend) {
                friendsListPresenter.navigateToPhotos(friend.id)
            }
        })

        editTextSearch.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

        })
    }

    override fun showError(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    override fun setupFriendsList(friendsList: List<VkFriend>) {
        adapter.setupFriends(friendsList)
    }


}
