package com.example.friends.ui.screens.friend_list

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.network.entity.friends.VkFriend
import com.example.friends.network.entity.friends.VkFriendResponse
import com.example.friends.network.repository.FriendRepository
import com.example.friends.ui.cicerone.FriendDetailScreen
import com.example.friends.ui.cicerone.PhotoScreen
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