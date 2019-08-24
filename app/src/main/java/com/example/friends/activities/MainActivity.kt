package com.example.friends.activities

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.friends.R
import com.example.friends.fragments.LoginFragment


class MainActivity : MvpAppCompatActivity(){


    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction().add(R.id.container, LoginFragment.getNewInstance()).commit()

    }


}
