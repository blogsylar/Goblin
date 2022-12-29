package ru.macdroid.goblin.presentation.login_page

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.macdroid.goblin.common.Constants
import ru.macdroid.goblin.common.Resource
import ru.macdroid.goblin.common.SharedPreference
import ru.macdroid.goblin.domain.model.login.LoginModel
import ru.macdroid.goblin.domain.use_case.login.GetSidUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getSidUseCase : GetSidUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun getSid(login: String, password: String) {
        getSidUseCase(login = login, password = password).onEach { result ->

            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(login = result.data)
                    saveDataToShared(result.data, login, password)
                }
                is Resource.Error -> {
                    _state.value = LoginState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

    private fun saveDataToShared(data: LoginModel?, login: String, password: String) {
        SharedPreference.savePreference(Constants.USER_LOGIN, login)
        SharedPreference.savePreference(Constants.USER_PASSWORD, password)
        SharedPreference.savePreference(Constants.SID, data?.data?.sid)
        SharedPreference.savePreference(Constants.TELEGRAM, false)
        SharedPreference.savePreference(Constants.ROLE, 1)
        SharedPreference.savePreference(Constants.API, 1)
    }

}