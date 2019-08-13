package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.model.entity.VkFriend
import com.example.friends.views.FriendsDetailView

@InjectViewState
class FriendDetailPresenter: MvpPresenter<FriendsDetailView>(){
    fun setFriendDetail(friend: VkFriend){

        val userName = "${friend.firstName} ${friend.lastName}"
        val photo = friend.photo_100

        viewState.showFriendInfo(userName, photo)
    }
}