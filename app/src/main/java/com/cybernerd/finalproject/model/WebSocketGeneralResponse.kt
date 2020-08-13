package com.cybernerd.finalproject.model

data class WebSocketGeneralResponse(
    val `for`: String,
    val messages: List<Message>,
    val msg: String,
    val status: Int
)