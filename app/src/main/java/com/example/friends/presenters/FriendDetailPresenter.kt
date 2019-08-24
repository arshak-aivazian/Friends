package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.views.FriendsDetailView

@InjectViewState
class FriendDetailPresenter(
    private val friend: VkFriend
) : MvpPresenter<FriendsDetailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val userName = "${friend.firstName} ${friend.lastName}\n ${friend.city?.title ?: "Город не укаазан"}"
        val photo = friend.photo_200
        viewState.showFriendInfo(userName, photo)
    }

    fun navigateToPhotos(id: Int){
        viewState?.navigateToPotos(id)
    }
}