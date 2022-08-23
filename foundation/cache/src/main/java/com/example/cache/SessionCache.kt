package com.example.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged

class SessionCache<T>(
    private val flow: MutableSharedFlow<T?>
) : Cache<T> {

    override suspend fun clear() {
        set(null)
    }

    override val value: Flow<T?> = flow.distinctUntilChanged()

    override suspend fun set(value: T?) {
        flow.emit(value)
    }
}