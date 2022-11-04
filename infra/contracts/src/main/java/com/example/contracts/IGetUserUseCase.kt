package com.example.contracts

import com.example.models.User
import kotlinx.coroutines.flow.Flow

interface IGetUserUseCase {
    operator fun invoke(): Flow<User>
}