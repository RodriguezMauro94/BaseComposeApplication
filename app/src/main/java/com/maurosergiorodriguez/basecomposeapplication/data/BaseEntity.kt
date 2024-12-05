package com.maurosergiorodriguez.basecomposeapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BaseEntity(
    @PrimaryKey
    val id: String,
    val description: String
)
