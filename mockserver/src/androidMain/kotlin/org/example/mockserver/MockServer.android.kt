package org.example.mockserver

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

actual fun startMockServer(port: Int) {
    embeddedServer(Netty, port = port, module = { mockRoutes() }).start(wait = false)
}
