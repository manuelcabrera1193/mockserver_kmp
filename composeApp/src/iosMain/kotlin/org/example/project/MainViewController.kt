package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.mockserver.MockServerProvider
import org.example.project.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer.start()
        MockServerProvider.initialize()
    },
    content = { App() },
)