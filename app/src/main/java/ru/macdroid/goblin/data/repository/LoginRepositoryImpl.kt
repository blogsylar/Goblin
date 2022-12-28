package ru.macdroid.goblin.data.repository

import ru.macdroid.goblin.data.remote.GoblinClient
import ru.macdroid.goblin.domain.model.LoginModel
import ru.macdroid.goblin.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: GoblinClient
) : LoginRepository {

    override suspend fun doLogin(login: String, password: String): LoginModel {
        return api.doLogin(login, password)
    }
}