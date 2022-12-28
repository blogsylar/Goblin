package ru.macdroid.goblin.domain.use_case.get_sid

import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.macdroid.goblin.common.Resource
import ru.macdroid.goblin.data.remote.login_dto.LoginErrorsDto
import ru.macdroid.goblin.data.remote.login_dto.LoginModelDto
import ru.macdroid.goblin.domain.model.LoginModel
import ru.macdroid.goblin.domain.repository.LoginRepository
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.macdroid.goblin.data.remote.login_dto.toLoginModel
import javax.inject.Inject

class GetSidUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    operator fun invoke(login: String, password: String) : Flow<Resource<LoginModelDto>> = flow {

        println("invoke")

        try {
            emit(Resource.Loading())
            val sid = repository.doLogin(login, password)
            emit(Resource.Success<LoginModelDto>(sid))
        }  catch(e: HttpException) {
            emit(Resource.Error<LoginModelDto>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<LoginModelDto>("Couldn't reach server. Check your internet connection."))
        }
    }
}