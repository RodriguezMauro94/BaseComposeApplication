package com.maurosergiorodriguez.basecomposeapplication.data

import com.maurosergiorodriguez.basecomposeapplication.ui.BaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRepository @Inject constructor(
    baseDAO: BaseDAO
) {
    val dataList: Flow<List<BaseModel>> = baseDAO.getData().map { data ->
        data.map {
            BaseModel(
                it.id,
                it.description
            )
        }
    }
}