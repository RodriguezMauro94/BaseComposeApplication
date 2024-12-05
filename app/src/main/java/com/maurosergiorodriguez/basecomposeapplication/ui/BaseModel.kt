package com.maurosergiorodriguez.basecomposeapplication.ui

import java.util.UUID

data class BaseModel(
    val id: String = UUID.randomUUID().toString(),
    val description: String
)