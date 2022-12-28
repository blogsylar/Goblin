package ru.macdroid.goblin.domain.model

data class LoginModel(
    val sid: String,
    val telegram: Boolean,
    val role: Int
)
