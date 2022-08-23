package com.example.provider

import kotlinx.coroutines.flow.Flow

interface Provider<T> {

    val value: T
}
