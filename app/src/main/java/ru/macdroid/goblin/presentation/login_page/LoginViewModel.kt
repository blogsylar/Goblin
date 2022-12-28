package ru.macdroid.goblin.presentation.login_page

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.macdroid.goblin.common.Resource
import ru.macdroid.goblin.domain.use_case.get_sid.GetSidUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getSidUseCase : GetSidUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

//    init {
//        getSid("v.zhdanov@saures.ru", "123456")
//
//    }

    fun getSid(login: String, password: String) {

        println("init get sid")

        getSidUseCase(login = login, password = password).onEach { result ->

            println("init get sid ${result.data}")

            when (result) {
                is Resource.Success -> {
                    println("success ${result.data}")
                    _state.value = LoginState(login = result.data)
                }
                is Resource.Error -> {
                    println("error ${result.data}")
                    _state.value = LoginState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    println("loading ${result.data}")
                    _state.value = LoginState(isLoading = true)
                }

            }
        }.launchIn(viewModelScope)
    }

}