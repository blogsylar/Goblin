package ru.macdroid.goblin.data.remote.login_dto


import com.google.gson.annotations.SerializedName
import ru.macdroid.goblin.domain.model.LoginModel

data class LoginModelDto(
    @SerializedName("data")
    val data: LoginDataDto,
    @SerializedName("errors")
    val errors: List<LoginErrorsDto>,
    @SerializedName("status")
    val status: String
)

fun LoginModelDto.toLoginModel() : LoginModel {
    return LoginModel(
        sid = data.sid,
        telegram = data.telegram,
        role = data.role
    )
}