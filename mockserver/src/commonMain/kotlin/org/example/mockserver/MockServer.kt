package org.example.mockserver

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import org.example.mockserver.response.LoginResponseJson

fun Application.mockRoutes() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        post("/login") {
            call.respondText(
                LoginResponseJson.data,
                ContentType.Application.Json,
                HttpStatusCode.OK,
            )
        }

        post("/user") {
            val request = call.receive<Map<String, String>>()
            call.respond(MockResponse("User ${request["name"]} created", 201))
        }
    }
}





