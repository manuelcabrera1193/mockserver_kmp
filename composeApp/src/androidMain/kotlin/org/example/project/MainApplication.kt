package org.example.project

import org.example.mockserver.MockServerProvider
import android.app.Application
import org.example.project.di.KoinInitializer
import org.koin.android.ext.koin.androidContext

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer.start { koinApplication ->
            koinApplication.androidContext(this@MainApplication)
        }
        MockServerProvider.initialize()
    }
}