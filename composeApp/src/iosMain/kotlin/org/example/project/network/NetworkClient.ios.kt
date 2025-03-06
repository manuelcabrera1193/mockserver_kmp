package org.example.project.network

import io.ktor.client.engine.darwin.Darwin

actual class NetworkClient {
    actual val client = createHttpClient(Darwin)
}