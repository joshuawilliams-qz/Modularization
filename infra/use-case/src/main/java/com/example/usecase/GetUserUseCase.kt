package com.example.usecase

import com.example.models.User
import com.example.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull

class GetUserUseCase(private val repository: UserRepository) {

    operator fun invoke(): Flow<User> = repository.user.filterNotNull()
}
