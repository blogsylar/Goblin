package ru.macdroid.goblin.data.remote.login_dto


import com.google.gson.annotations.SerializedName
import ru.macdroid.goblin.domain.model.LoginModel

data class LoginDataDto(
    @SerializedName("api")
    val api: Int,
    @SerializedName("role")
    val role: Int,
    @SerializedName("sid")
    val sid: String,
    @SerializedName("telegram")
    val telegram: Boolean
)

