package com.example.friends.fragments


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.friends.R
import com.example.friends.activities.MainActivity
import com.example.friends.adapters.FriendsAdapter
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.presenters.FriendsListPresenter
import com.example.friends.views.FriendsListView
import kotlinx.android.synthetic.main.fragment_friends_list.*


class FriendsListFragment : MvpAppCompatFragment(), FriendsListView {
    companion object{
        fun getNewInstance(): FriendsListFragment{
            return FriendsListFragment()
        }

        fun toFriendsListFragment(activity: MainActivity){
            activity.fragmentManager.beginTransaction().replace(R.id.container, FriendsListFragment.getNewInstance())
                .addToBackStack(null).commit()
        }
    }

    @InjectPresenter
    lateinit var friendsListPresenter: FriendsListPresenter


    val adapter = FriendsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclreViewFriends.layoutManager = activity?.let { LinearLayoutManager(it, OrientationHelper.VERTICAL, false) }
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

    override fun navigateToFriendDetail(friend: VkFriend) {
        FriendDetailFragment.toFriendDetailFragment(activity as MainActivity, friend)
    }

    override fun navigateToFriendPhotos(userId: Int) {
        PhotosFragment.toPhotosFragment(activity as MainActivity, userId)
    }
}
