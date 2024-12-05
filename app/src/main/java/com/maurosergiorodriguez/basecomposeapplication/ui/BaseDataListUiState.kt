package com.maurosergiorodriguez.basecomposeapplication.ui

public sealed interface BaseDataListUiState {
    data object Loading : BaseDataListUiState
    data class Error(
        val throwable: Throwable
    ) : BaseDataListUiState
    data class Success(
        val items: List<BaseModel>
    ) : BaseDataListUiState
}