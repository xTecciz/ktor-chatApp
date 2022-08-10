package ktor_chatApp.plugins

import io.ktor.server.sessions.*
import io.ktor.server.application.*
import io.ktor.util.*
import ktor_chatApp.sessions.ChatSession

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }
    intercept(ApplicationCallPipeline.Plugins){
        if (call.sessions.get<ChatSession>() == null) {
            val username = call.parameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(username, generateNonce()))
        }
    }
}
