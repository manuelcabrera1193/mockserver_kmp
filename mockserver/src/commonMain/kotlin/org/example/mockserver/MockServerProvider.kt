package org.example.mockserver

object MockServerProvider {
    fun initialize() {
        try {
            val port = 9595
            startMockServer(port)
            println("MockServer started on port $port")
        } catch (throwable: Throwable) {
            println("Failed to start MockServer")
            throwable.printStackTrace()
        }
    }
}