package ktor_chatApp.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import ktor_chatApp.room.RoomController
import ktor_chatApp.routes.chatSocket
import ktor_chatApp.routes.clearDB
import ktor_chatApp.routes.getAllMessages
import ktor_chatApp.routes.root
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    routing {
        root()
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
        clearDB(roomController = roomController)
    }
}
