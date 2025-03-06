package org.example.project.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.example.project.models.LoginRequest
import org.example.project.models.LoginResponse

class AuthRepository(private val client: HttpClient) {
    suspend fun login(email: String, password: String): LoginResponse {
        val response: HttpResponse = client.post("http://localhost:9595/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(email, password))
        }
        return response.body()
    }
}