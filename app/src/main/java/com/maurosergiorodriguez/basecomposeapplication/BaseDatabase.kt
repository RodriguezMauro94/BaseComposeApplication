package com.maurosergiorodriguez.basecomposeapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maurosergiorodriguez.basecomposeapplication.data.BaseDAO
import com.maurosergiorodriguez.basecomposeapplication.data.BaseEntity

@Database(entities = [BaseEntity::class], version = 1)
abstract class BaseDatabase: RoomDatabase() {
    abstract fun baseDAO(): BaseDAO
}