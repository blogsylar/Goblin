package ru.macdroid.goblin.domain.use_case.get_sid

import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.macdroid.goblin.common.Resource
import ru.macdroid.goblin.data.remote.login_dto.LoginModelDto
import ru.macdroid.goblin.domain.repository.LoginRepository
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import ru.macdroid.goblin.domain.model.LoginModel
import javax.inject.Inject

class GetSidUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    operator fun invoke(login: String, password: String) : Flow<Resource<LoginModel>> = flow {
        try {
            emit(Resource.Loading())
            val loginData = repository.doLogin(login, password)
            emit(Resource.Success<LoginModel>(loginData))
        }  catch(e: HttpException) {
            emit(Resource.Error<LoginModel>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<LoginModel>("Couldn't reach server. Check your internet connection."))
        }
    }
}