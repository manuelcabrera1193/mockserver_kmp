package org.example.project.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import kotlin.jvm.JvmStatic

object KoinInitializer {
    @JvmStatic
    fun start(config: (KoinApplication) -> Unit = {}) {
        startKoin {
            config.invoke(this)
            modules(sharedModule)
        }
    }
}
