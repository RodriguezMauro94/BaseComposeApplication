package com.maurosergiorodriguez.basecomposeapplication

import android.content.Context
import androidx.room.Room
import com.maurosergiorodriguez.basecomposeapplication.data.BaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): BaseDatabase {
        return Room.databaseBuilder(
            appContext,
            BaseDatabase::class.java,
            "BaseDatabase"
        ).build()
    }

    @Provides
    fun providesBaseDao(baseDatabase: BaseDatabase): BaseDAO {
        return baseDatabase.baseDAO()
    }
}