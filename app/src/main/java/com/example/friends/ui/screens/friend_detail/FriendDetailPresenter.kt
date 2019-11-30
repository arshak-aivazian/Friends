package com.example.friends.ui.screens.friend_detail

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.ui.cicerone.PhotoScreen
import ru.terrakok.cicerone.Router

@InjectViewState
class FriendDetailPresenter(private val router: Router,
    private val friend: VkFriend
) : MvpPresenter<FriendsDetailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val userName = "${friend.firstName} ${friend.lastName}\n ${friend.city?.title ?: "Город не укаазан"}"
        val photo = friend.photo_200
        viewState.showFriendInfo(userName, photo)
    }

    fun navigateToPhotos(id: Int){
        router.navigateTo(PhotoScreen(id))
    }
}