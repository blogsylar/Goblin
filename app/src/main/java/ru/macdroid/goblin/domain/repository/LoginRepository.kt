package ru.macdroid.goblin.domain.repository

import ru.macdroid.goblin.data.remote.login_dto.LoginModelDto
import ru.macdroid.goblin.domain.model.LoginModel

interface LoginRepository {

    suspend fun doLogin(login: String, password: String): LoginModelDto

}