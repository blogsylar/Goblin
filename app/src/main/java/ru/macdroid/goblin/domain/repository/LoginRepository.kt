package ru.macdroid.goblin.domain.repository

import ru.macdroid.goblin.domain.model.LoginModel

interface LoginRepository {

    suspend fun doLogin(login: String, password: String): LoginModel

}