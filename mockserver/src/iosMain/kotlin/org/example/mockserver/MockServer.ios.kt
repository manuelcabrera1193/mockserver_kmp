package org.example.mockserver

import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer

actual fun startMockServer(port: Int) {
    embeddedServer(CIO, port = port, module = { mockRoutes() }).start(wait = false)
}
