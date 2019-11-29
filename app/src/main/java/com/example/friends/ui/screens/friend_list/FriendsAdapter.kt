package com.example.friends.ui.screens.friend_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friends.R
import com.example.friends.network.entity.friends.VkFriend
import com.squareup.picasso.Picasso

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    private var friendsListener: FriendsListener? = null

    interface FriendsListener {
        fun onSelectFriend(friend: VkFriend)
    }

    fun setFriendsListener(listener: FriendsListener) {
        this.friendsListener = listener
    }

    private var itemFriendsListener: ItemFriendsListener? = null

    interface ItemFriendsListener {
        fun onClickButtonItem(friend: VkFriend)
    }

    fun setItemFriendsListener(listener: ItemFriendsListener) {
        this.itemFriendsListener = listener
    }


    private var friendsList: ArrayList<VkFriend> = ArrayList()
    private var sourceList: ArrayList<VkFriend> = ArrayList()

    fun setupFriends(arrayList: List<VkFriend>) {
        sourceList.clear()
        sourceList.addAll(arrayList)
        notifyDataSetChanged()
        filter(query = "")
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FriendViewHolder {
        return FriendViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.friend_item, parent, false))
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }

    override fun onBindViewHolder(itemViewHolder: FriendViewHolder, position: Int) {
        itemViewHolder.itemView.itemFriend.itemButtonToGroups.setOnClickListener({
            itemFriendsListener?.onClickButtonItem(friend = friendsList[position])
        })
        itemViewHolder.bind(friendsList[position])
    }

    fun filter(query: String) {
        friendsList.clear()
        sourceList.forEach({
            if((it.firstName?.contains(query, ignoreCase = true)!! )|| (it.lastName?.contains(query, ignoreCase = true)!!))
                friendsList.add(it)
        })
        notifyDataSetChanged()
    }

    inner class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                friendsListener?.onSelectFriend(friendsList[adapterPosition])
            }
        }

        fun bind(vkFriendResponse: VkFriend) {

            Picasso.get().load(vkFriendResponse.photo_200).into(itemView.civAvatar)
            itemView.textViewFriendName.text = "${vkFriendResponse.firstName} ${vkFriendResponse.lastName}"
            itemView.textViewOnline.text = if (vkFriendResponse.online == 1) "onLine" else "offLine"

        }

    }


}