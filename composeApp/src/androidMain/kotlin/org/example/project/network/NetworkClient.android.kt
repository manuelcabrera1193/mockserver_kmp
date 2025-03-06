package org.example.project.network

import io.ktor.client.engine.okhttp.OkHttp


actual class NetworkClient {
    actual val client = createHttpClient(OkHttp)
}