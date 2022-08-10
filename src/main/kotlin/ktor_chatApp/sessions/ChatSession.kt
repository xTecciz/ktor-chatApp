package ktor_chatApp.sessions

data class ChatSession(
    val username: String,
    val sessionId: String
)