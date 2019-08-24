package com.example.friends.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.R
import com.example.friends.activities.MainActivity
import com.example.friends.adapters.PhotosAdapter
import com.example.friends.model.entity.photo.VkPhoto
import com.example.friends.presenters.PhotosPresenter
import com.example.friends.views.PhotosView
import kotlinx.android.synthetic.main.fragment_photos.*


class PhotosFragment : MvpAppCompatFragment(), PhotosView {

    companion object {
        val KEY_ID = "USER_ID"
        fun getNewInstance(userId: Int): PhotosFragment {
            val fragment = PhotosFragment()
            val args = Bundle()
            args.putInt(KEY_ID, userId)
            fragment.arguments = args
            return fragment
        }

        fun toPhotosFragment(activity: MainActivity, userId: Int){
            activity.fragmentManager.beginTransaction().replace(R.id.container, PhotosFragment.getNewInstance(userId))
                .addToBackStack(null).commit()
        }
    }

    @InjectPresenter
    lateinit var photosPresenter: PhotosPresenter

    @ProvidePresenter
    fun providePresenter(): PhotosPresenter {
        val userId = arguments!!.getInt(KEY_ID)
        return PhotosPresenter(userId)
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
