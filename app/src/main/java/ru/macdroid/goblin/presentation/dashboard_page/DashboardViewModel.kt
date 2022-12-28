package ru.macdroid.goblin.presentation.dashboard_page

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.macdroid.goblin.domain.use_case.get_sid.GetSidUseCase
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        println("get from state ${savedStateHandle.keys()}")
    }

}
