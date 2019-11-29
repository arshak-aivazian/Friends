package com.example.friends.ui.cicerone

import android.os.Bundle
import androidx.core.app.Fragment
import com.example.friends.ui.screens.photo.PhotosFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class PhotoScreen(private val userId: Int) : SupportAppScreen() {
    companion object {
        const val KEY_ID = "USER_ID"
    }

    override fun getFragment(): Fragment {
        val fragment = PhotosFragment.getNewInstance()
        val args = Bundle()
        args.putInt(KEY_ID, userId)
        fragment.arguments = args
        return fragment
    }
}