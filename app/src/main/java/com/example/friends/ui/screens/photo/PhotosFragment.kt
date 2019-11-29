package com.example.friends.ui.screens.photo


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.MyApp
import com.example.friends.R
import com.example.friends.network.entity.photo.VkPhoto
import com.example.friends.ui.cicerone.PhotoScreen


class PhotosFragment : MvpAppCompatFragment(), PhotosView {

    companion object {
        fun getNewInstance(): PhotosFragment {
            return PhotosFragment()
        }
    }

    @InjectPresenter
    lateinit var photosPresenter: PhotosPresenter

    @ProvidePresenter
    fun providePresenter(): PhotosPresenter {
        val router = (activity?.application as MyApp).router
        val userId = arguments!!.getInt(PhotoScreen.KEY_ID)
        return PhotosPresenter(router, userId)
    }

    val adapter = PhotosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewPhotos.layoutManager = LinearLayoutManager(activity)
        recyclerViewPhotos.adapter = adapter
    }

    override fun setupPhotos(photosList: List<VkPhoto>) {
        adapter.setupPhotos(photosList)
    }

    override fun showError(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }

}
