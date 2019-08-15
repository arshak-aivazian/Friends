package com.example.friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.friends.model.entity.photo.VkPhotoResponse
import com.example.friends.model.repository.PhotoRepositiry
import com.example.friends.views.PhotosView
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

@InjectViewState
class PhotosPresenter(val id: Int) : MvpPresenter<PhotosView>() {
    private val repository = PhotoRepositiry()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository
            .getPhotos(id, object : VKApiCallback<VkPhotoResponse> {
                override fun fail(error: VKApiExecutionException) {
                    viewState?.showError(error.message.orEmpty())
                }

                override fun success(result: VkPhotoResponse) {
                    viewState?.setupPhotos(result.items)
                }
            })
    }
}