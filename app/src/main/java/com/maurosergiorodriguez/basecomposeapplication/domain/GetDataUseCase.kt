package com.maurosergiorodriguez.basecomposeapplication.domain

import com.maurosergiorodriguez.basecomposeapplication.data.BaseRepository
import com.maurosergiorodriguez.basecomposeapplication.ui.BaseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val baseRepository: BaseRepository
) {
    operator fun invoke(): Flow<List<BaseModel>> {
        return baseRepository.dataList
    }
}