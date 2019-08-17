package com.example.friends

import android.app.Application
import com.vk.api.sdk.VK
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class MyApp : Application() {

    lateinit var cicerone: Cicerone<Router>
    lateinit var router: Router
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate() {
        super.onCreate()
        cicerone = Cicerone.create()
        router = cicerone.router
        navigationHolder = cicerone.navigatorHolder
        VK.initialize(this)
    }
}