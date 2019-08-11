package com.example.friends.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friends.R
import com.example.friends.model.entity.VkFriend
import com.example.friends.model.entity.VkFriendResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.friend_item.view.*

class FriendsAdapter: RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    interface FriendsListener{
        fun onSelectFriend(vkFriend: VkFriend)
    }

    var listener : FriendsListener?=null
    private var friendsList: ArrayList<VkFriend> = ArrayList()

    fun setupFriends(arrayList: List<VkFriend>) {
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

    inner class FriendViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                listener?.onSelectFriend(friendsList[adapterPosition])
            }
        }

        fun bind(vkFriendResponse: VkFriend){
            //Picasso.get().load(vkFriendResponse.avatar).into(itemView.friends_civ_avatar)
            itemView.textViewFriendName.text = "${vkFriendResponse.firstName} ${vkFriendResponse.lastName}"
        }

    }


}