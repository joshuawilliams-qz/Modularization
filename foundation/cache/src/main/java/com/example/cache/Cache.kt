package com.example.cache

import kotlinx.coroutines.flow.Flow

interface Cache<T> {

    suspend fun clear()

    val value: Flow<T?>

    suspend fun set(value: T?)

    operator fun invoke(): Flow<T?> = value
}

