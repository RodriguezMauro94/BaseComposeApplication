package com.maurosergiorodriguez.basecomposeapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maurosergiorodriguez.basecomposeapplication.domain.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.maurosergiorodriguez.basecomposeapplication.ui.BaseDataListUiState.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class BaseViewModel @Inject constructor(
    val getDataUseCase: GetDataUseCase
): ViewModel() {
    val baseUiDataList: StateFlow<BaseDataListUiState> = getDataUseCase()
        .map(::Success)
        .catch {
            Error(it)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            Loading
        )
}

