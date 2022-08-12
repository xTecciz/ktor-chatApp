package ktor_chatApp.room

class MemberExistsException : Exception(
    "There is already a member with that username."
)