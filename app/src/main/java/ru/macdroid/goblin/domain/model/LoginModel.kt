package ru.macdroid.goblin.domain.model


import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("data")
    val data: LoginData,
    @SerializedName("errors")
    val errors: List<LoginErrors>,
    @SerializedName("status")
    val status: String
)
