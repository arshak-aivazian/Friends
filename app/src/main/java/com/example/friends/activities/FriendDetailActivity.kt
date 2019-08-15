package com.example.friends.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.R
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.presenters.FriendDetailPresenter
import com.example.friends.views.FriendsDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_friend_detail.*
import kotlinx.android.synthetic.main.activity_friends_list.*
import kotlinx.android.synthetic.main.friend_item.view.*

class FriendDetailActivity : MvpAppCompatActivity(), FriendsDetailView {

    lateinit var friend: VkFriend

    companion object{

        private const val KEY_FRIEND ="friendObject"

        fun startActivity(activity: Activity, friend: VkFriend){
            val intent = Intent(activity, FriendDetailActivity::class.java)
            intent.putExtra(KEY_FRIEND, friend)
            activity.startActivity(intent)
        }

    }

    @InjectPresenter
    lateinit var friendDetailPresenter: FriendDetailPresenter

    @ProvidePresenter
    fun providePresenter() : FriendDetailPresenter{
        val intent: Intent = intent
        friend = intent.getSerializableExtra(KEY_FRIEND) as VkFriend
        return FriendDetailPresenter(friend)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_detail)

        buttonShowPhotos.setOnClickListener({
            friendDetailPresenter.navigateToPhotos(friend.id)
        })


    }

    override fun showFriendInfo(userName: String, avatar: String) {
        textView.text = userName
        Picasso.get().load(avatar).into(imageViewPhoto)
    }

    override fun navigateToPhotos(userId: Int) {
        PhotosActivity.startActivity(this, userId)
    }

}
