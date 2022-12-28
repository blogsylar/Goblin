package ru.macdroid.goblin.data.remote.login_dto


import com.google.gson.annotations.SerializedName

data class LoginModelDto(
    @SerializedName("data")
    val data: LoginDataDto,
    @SerializedName("errors")
    val errors: List<LoginErrorsDto>,
    @SerializedName("status")
    val status: String
)
