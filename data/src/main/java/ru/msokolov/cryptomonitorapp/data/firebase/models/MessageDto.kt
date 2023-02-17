package ru.msokolov.cryptomonitorapp.data.firebase.models

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
