package org.example.mockserver

import kotlinx.serialization.Serializable

@Serializable
data class MockResponse(val message: String, val status: Int)