package org.example.mockserver.response

object LoginResponseJson {

    val data: String
        get() {
            return """
                {
                    "token": "abc123",
                    "message": "Login successful"
                }
                """.trimIndent()
        }
}