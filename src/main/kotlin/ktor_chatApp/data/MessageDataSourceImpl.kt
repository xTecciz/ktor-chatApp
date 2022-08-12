package ktor_chatApp.data

import ktor_chatApp.data.model.MessageModel
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    private val db: CoroutineDatabase
) : MessageDataSource {

    private val messages = db.getCollection<MessageModel>()

    override suspend fun getAllMessages(): List<MessageModel> {
        return messages.find()
            .descendingSort(MessageModel::timestamp)
            .toList()
    }

    override suspend fun insertMessage(message: MessageModel) {
        messages.insertOne(message)
    }

    override suspend fun clearDB(){
        messages.deleteMany()
    }
}