package com.example.friends.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.friends.R
import com.example.friends.adapters.PhotosAdapter
import com.example.friends.model.entity.friends.VkFriend
import com.example.friends.model.entity.photo.VkPhoto
import com.example.friends.presenters.FriendDetailPresenter
import com.example.friends.presenters.PhotosPresenter
import com.example.friends.views.PhotosView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photos.*
import kotlinx.android.synthetic.main.friend_item.view.*

class PhotosActivity : MvpAppCompatActivity(), PhotosView {
    @InjectPresenter
    lateinit var photosPresenter: PhotosPresenter

    @ProvidePresenter
    fun providePresenter() : PhotosPresenter {
        val intent: Intent = intent
        val userId = intent.getIntExtra(KEY_ID, 0)
        return PhotosPresenter(userId)
    }

    companion object{

        private const val KEY_ID ="USER_ID"

        fun startActivity(activity: Activity, userId: Int){
            val intent = Intent(activity, PhotosActivity::class.java)
            intent.putExtra(KEY_ID, userId)
            activity.startActivity(intent)
        }

    }
    val adapter = PhotosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        recyclerViewPhotos.layoutManager = LinearLayoutManager(this)
        recyclerViewPhotos.adapter = adapter
    }

    override fun setupPhotos(photosList: List<VkPhoto>) {
        adapter.setupPhotos(photosList)
    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        Log.i("TAAAG", text)
    }
}
