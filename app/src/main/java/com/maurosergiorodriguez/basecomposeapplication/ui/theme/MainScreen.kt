package com.maurosergiorodriguez.basecomposeapplication.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.maurosergiorodriguez.basecomposeapplication.ui.BaseDataListUiState
import com.maurosergiorodriguez.basecomposeapplication.ui.BaseViewModel

@Composable
fun BaseScreen(baseViewModel: BaseViewModel, modifier: Modifier) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val baseListUiState by produceState<BaseDataListUiState>(
        initialValue = BaseDataListUiState.Loading,
        key1 = lifecycle,
        key2 = baseViewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            baseViewModel.baseUiDataList.collect {
                value = it
            }
        }
    }

    Scaffold(
        modifier =  modifier
    ) { padding ->
        when(baseListUiState) {
            is BaseDataListUiState.Error -> {
                //TODO show a retry
            }
            BaseDataListUiState.Loading -> {
                //TODO show a loading
            }
            is BaseDataListUiState.Success -> {
                val items = (baseListUiState as BaseDataListUiState.Success).items
                LazyColumn(
                    modifier = Modifier.padding(padding)
                ) {
                    items(items, key = { it.id }) { item ->
                        Text("ID: ${item.id}")
                        Text("Description: ${item.description}")
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }
        }
    }
}