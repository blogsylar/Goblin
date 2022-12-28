package ru.macdroid.goblin.domain.model


import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("api")
    val api: Int,
    @SerializedName("role")
    val role: Int,
    @SerializedName("sid")
    val sid: String,
    @SerializedName("telegram")
    val telegram: Boolean
)

