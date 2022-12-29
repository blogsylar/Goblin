package ru.macdroid.goblin.presentation.login_page

import ru.macdroid.goblin.domain.model.login.LoginModel

class LoginState(
    val isLoading: Boolean = false,
    val login: LoginModel? = null,
    val error: String = ""
) {
}