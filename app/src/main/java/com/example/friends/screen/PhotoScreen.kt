package com.example.friends.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.friends.fragments.PhotosFragment
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