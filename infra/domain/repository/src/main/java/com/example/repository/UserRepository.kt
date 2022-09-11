package com.example.repository

import com.example.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val user: Flow<User?>
}
