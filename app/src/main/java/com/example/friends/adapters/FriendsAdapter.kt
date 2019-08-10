package com.example.friends.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friends.R
import com.example.friends.activities.FriendsListActivity
import com.example.friends.pojo.Friend
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.friend_item.view.*

class FriendsAdapter: RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    private var friendsList: ArrayList<Friend> = ArrayList()

    fun setupFriends(arrayList: ArrayList<Friend>) {
        friendsList.clear()
        friendsList.addAll(arrayList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FriendViewHolder {
        return FriendViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.friend_item, parent, false))
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }

    override fun onBindViewHolder(itemViewHolder: FriendViewHolder, position: Int) {
        itemViewHolder.bind(friendsList[position])
    }

    class FriendViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {

            }
        }

        fun bind(friend: Friend){
            Picasso.get().load(friend.avatar).into(itemView.friends_civ_avatar)
            itemView.textViewFriendName.text = "${friend.name} ${friend.secondName}"
        }

    }


}