package com.example.usecase

import com.example.contracts.IGetUserUseCase
import com.example.models.User
import com.example.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull

class GetUserUseCase(private val repository: UserRepository) : IGetUserUseCase {

    override operator fun invoke(): Flow<User> = repository.user.filterNotNull()
}
