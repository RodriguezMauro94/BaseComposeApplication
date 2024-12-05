package com.maurosergiorodriguez.basecomposeapplication.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BaseDAO {
    @Query("SELECT * FROM BaseEntity")
    fun getData(): Flow<List<BaseEntity>>
}