package ru.msokolov.cryptomonitorapp.data.repository.models

data class MessageDto(
    val text: String,
    val senderId: String,
    val receiverId: String
){
    public constructor(): this(
        "",
        "",
        ""
    )
}
