package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.model.entity.friends.VkFriendResponse
import com.example.friends.model.repository.FriendRepository
import com.example.friends.screen.FriendDetailScreen
import com.example.friends.screen.PhotoScreen
import com.example.friends.views.FriendsListView
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException
import ru.terrakok.cicerone.Router

@InjectViewState
class FriendsListPresenter(private val router: Router): MvpPresenter<FriendsListView>() {

    private val repository = FriendRepository()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository
            .getFriends(object : VKApiCallback<VkFriendResponse>{
                override fun fail(error: VKApiExecutionException) {
                    viewState?.showError(error.message.orEmpty())
                }

                override fun success(result: VkFriendResponse) {
                    viewState?.setupFriendsList(result.items)
                }
            })
    }

    fun onFriendSelected(friend: VkFriend){
        router.navigateTo(FriendDetailScreen(friend))
    }

    fun navigateToPhotos(id: Int){
        router.navigateTo(PhotoScreen(id))
    }

}