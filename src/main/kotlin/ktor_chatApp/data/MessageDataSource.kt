package ktor_chatApp.data

import ktor_chatApp.data.model.MessageModel

interface MessageDataSource {
    suspend fun getAllMessages(): List<MessageModel>

    suspend fun insertMessage(message: MessageModel)
    suspend fun clearDB()
}