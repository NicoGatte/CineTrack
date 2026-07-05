package com.cinetrack.app

import android.app.Application
import com.cinetrack.app.di.AppContainer

class CineTrackApp : Application() {
    lateinit var container: AppContainer
        private set
    
    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
