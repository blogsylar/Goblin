package ru.macdroid.goblin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.macdroid.goblin.common.Constants
import ru.macdroid.goblin.data.remote.GoblinClient
import ru.macdroid.goblin.data.repository.LoginRepositoryImpl
import ru.macdroid.goblin.domain.repository.LoginRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGoblinClient() : GoblinClient {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoblinClient::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepositiry(api: GoblinClient) : LoginRepository {
        return LoginRepositoryImpl(api)
    }

}