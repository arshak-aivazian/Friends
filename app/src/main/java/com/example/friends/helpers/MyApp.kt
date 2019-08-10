package com.example.friends.helpers

import android.app.Application
import com.vk.sdk.VKSdk

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(applicationContext)
    }
}