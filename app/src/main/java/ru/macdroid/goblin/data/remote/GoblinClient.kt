package ru.macdroid.goblin.data.remote

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import ru.macdroid.goblin.common.Constants
import ru.macdroid.goblin.domain.model.login.LoginModel

interface GoblinClient {

    @FormUrlEncoded
    @POST(Constants.END_POINT_LOGIN)
    suspend fun doLogin(
        @Field("email") login: String?,
        @Field("password") password: String?
    ): LoginModel

}