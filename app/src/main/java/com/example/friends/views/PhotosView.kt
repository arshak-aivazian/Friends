package com.example.friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.friends.model.entity.photo.VkPhoto

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface PhotosView: MvpView {
    fun setupPhotos(photosList: List<VkPhoto>)
    fun showError(text: String)
}