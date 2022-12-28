package ru.macdroid.goblin.presentation.login_page

import ru.macdroid.goblin.data.remote.login_dto.LoginModelDto
import ru.macdroid.goblin.domain.model.LoginModel

class LoginState(
    val isLoading: Boolean = false,
    val login: LoginModelDto? = null,
    val error: String = ""
) {
}