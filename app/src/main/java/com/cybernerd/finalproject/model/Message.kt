package com.cybernerd.finalproject.model

data class Message(
    val created_at: String,
    val group: Group,
    val id: Int,
    val is_active: Boolean,
    val message: String,
    val sender: SenderX
)